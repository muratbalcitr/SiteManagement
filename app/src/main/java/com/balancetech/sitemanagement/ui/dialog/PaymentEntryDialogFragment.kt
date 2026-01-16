package com.balancetech.sitemanagement.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.balancetech.sitemanagement.databinding.DialogPaymentEntryBinding
import com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentEntryDialogFragment : DialogFragment() {
    private var _binding: DialogPaymentEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PaymentViewModel by viewModels()

    private var onPaymentRecordedListener: (() -> Unit)? = null

    companion object {
        private const val ARG_FEE_ID = "fee_id"
        private const val ARG_WATER_BILL_ID = "water_bill_id"
        private const val ARG_EXTRA_PAYMENT_ID = "extra_payment_id"
        private const val ARG_UNIT_ID = "unit_id"
        private const val ARG_MAX_AMOUNT = "max_amount"
        private const val ARG_PAYMENT_TYPE = "payment_type"

        fun newInstance(
            unitId: String,
            maxAmount: Double,
            paymentType: PaymentType,
            feeId: String? = null,
            waterBillId: String? = null,
            extraPaymentId: String? = null
        ): PaymentEntryDialogFragment {
            return PaymentEntryDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_UNIT_ID, unitId)
                    putDouble(ARG_MAX_AMOUNT, maxAmount)
                    putString(ARG_PAYMENT_TYPE, paymentType.name)
                    feeId?.let { putString(ARG_FEE_ID, it) }
                    waterBillId?.let { putString(ARG_WATER_BILL_ID, it) }
                    extraPaymentId?.let { putString(ARG_EXTRA_PAYMENT_ID, it) }
                }
            }
        }
    }

    enum class PaymentType {
        FEE, WATER_BILL, EXTRA_PAYMENT, GENERAL
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogPaymentEntryBinding.inflate(layoutInflater)

        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        )

        setupPaymentMethodSpinner()
        setupButtons()
        observeViewModel()

        val maxAmount = arguments?.getDouble(ARG_MAX_AMOUNT) ?: 0.0
        if (maxAmount > 0) {
            binding.amountEditText.hint = "Maksimum: ${String.format("%.2f", maxAmount)} ₺"
        }

        return dialog
    }

    private fun setupPaymentMethodSpinner() {
        val paymentMethods = arrayOf("Banka Transferi", "Nakit")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, paymentMethods)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.paymentMethodSpinner.adapter = adapter
    }

    private fun setupButtons() {
        binding.recordButton.setOnClickListener {
            recordPayment()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun recordPayment() {
        val unitId = arguments?.getString(ARG_UNIT_ID) ?: return
        val maxAmount = arguments?.getDouble(ARG_MAX_AMOUNT) ?: 0.0
        val amountText = binding.amountEditText.text.toString().trim()
        val description = binding.descriptionEditText.text.toString().trim()

        if (amountText.isEmpty()) {
            Toast.makeText(requireContext(), "Lütfen tutarı girin", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(requireContext(), "Geçerli bir tutar girin", Toast.LENGTH_SHORT).show()
            return
        }

        if (maxAmount > 0 && amount > maxAmount) {
            Toast.makeText(
                requireContext(),
                "Tutar maksimum tutardan fazla olamaz",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val paymentMethod = when (binding.paymentMethodSpinner.selectedItem.toString()) {
            "Nakit" -> "cash"
            "Banka Transferi" -> "bank_transfer"
            else -> "bank_transfer"
        }

        val paymentType = arguments?.getString(ARG_PAYMENT_TYPE)?.let {
            PaymentType.valueOf(it)
        } ?: PaymentType.GENERAL

        val feeId = if (paymentType == PaymentType.FEE) arguments?.getString(ARG_FEE_ID) else null
        val waterBillId =
            if (paymentType == PaymentType.WATER_BILL) arguments?.getString(ARG_WATER_BILL_ID) else null
        val extraPaymentId =
            if (paymentType == PaymentType.EXTRA_PAYMENT) arguments?.getString(ARG_EXTRA_PAYMENT_ID) else null

        viewModel.recordPayment(
            unitId = unitId,
            amount = amount,
            paymentMethod = paymentMethod,
            description = description.ifEmpty { null },
            feeId = feeId,
            extraPaymentId = extraPaymentId,
            waterBillId = waterBillId
        )
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState.Success -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        onPaymentRecordedListener?.invoke()
                        dismiss()
                    }

                    is com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }

                    else -> {}
                }
            }
        }
    }

    fun setOnPaymentRecordedListener(listener: () -> Unit) {
        onPaymentRecordedListener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

