package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.BankTransaction
import com.balancetech.sitemanagement.databinding.ItemBankTransactionBinding

class BankTransactionAdapter : ListAdapter<BankTransaction, BankTransactionAdapter.TransactionViewHolder>(
    TransactionDiffCallback()
) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemBankTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class TransactionViewHolder(
        private val binding: ItemBankTransactionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(transaction: BankTransaction) {
            binding.apply {
                dateText.text = transaction.date
                receiptNoText.text = transaction.receiptNo
                descriptionText.text = transaction.description
                
                // Format amount with color coding
                val amountFormatted = String.format("%.2f ₺", transaction.amount)
                amountText.text = amountFormatted
                amountText.setTextColor(
                    if (transaction.isIncome) {
                        root.context.getColor(android.R.color.holo_green_dark)
                    } else {
                        root.context.getColor(android.R.color.holo_red_dark)
                    }
                )
                
                // Format balance
                balanceText.text = String.format("%.2f ₺", transaction.balance)
            }
        }
    }
    
    class TransactionDiffCallback : DiffUtil.ItemCallback<BankTransaction>() {
        override fun areItemsTheSame(oldItem: BankTransaction, newItem: BankTransaction): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: BankTransaction, newItem: BankTransaction): Boolean {
            return oldItem == newItem
        }
    }
}
