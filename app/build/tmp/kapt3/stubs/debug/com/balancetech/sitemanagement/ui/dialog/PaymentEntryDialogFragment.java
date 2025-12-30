package com.balancetech.sitemanagement.ui.dialog;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0014\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/DialogPaymentEntryBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/DialogPaymentEntryBinding;", "onPaymentRecordedListener", "Lkotlin/Function0;", "", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "recordPayment", "setOnPaymentRecordedListener", "listener", "setupButtons", "setupPaymentMethodSpinner", "Companion", "PaymentType", "app_debug"})
public final class PaymentEntryDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.DialogPaymentEntryBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onPaymentRecordedListener;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_FEE_ID = "fee_id";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_WATER_BILL_ID = "water_bill_id";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_EXTRA_PAYMENT_ID = "extra_payment_id";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_UNIT_ID = "unit_id";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_MAX_AMOUNT = "max_amount";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_PAYMENT_TYPE = "payment_type";
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment.Companion Companion = null;
    
    public PaymentEntryDialogFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.DialogPaymentEntryBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupPaymentMethodSpinner() {
    }
    
    private final void setupButtons() {
    }
    
    private final void recordPayment() {
    }
    
    private final void observeViewModel() {
    }
    
    public final void setOnPaymentRecordedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JB\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment$Companion;", "", "()V", "ARG_EXTRA_PAYMENT_ID", "", "ARG_FEE_ID", "ARG_MAX_AMOUNT", "ARG_PAYMENT_TYPE", "ARG_UNIT_ID", "ARG_WATER_BILL_ID", "newInstance", "Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment;", "unitId", "maxAmount", "", "paymentType", "Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment$PaymentType;", "feeId", "waterBillId", "extraPaymentId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment newInstance(@org.jetbrains.annotations.NotNull
        java.lang.String unitId, double maxAmount, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment.PaymentType paymentType, @org.jetbrains.annotations.Nullable
        java.lang.String feeId, @org.jetbrains.annotations.Nullable
        java.lang.String waterBillId, @org.jetbrains.annotations.Nullable
        java.lang.String extraPaymentId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment$PaymentType;", "", "(Ljava/lang/String;I)V", "FEE", "WATER_BILL", "EXTRA_PAYMENT", "GENERAL", "app_debug"})
    public static enum PaymentType {
        /*public static final*/ FEE /* = new FEE() */,
        /*public static final*/ WATER_BILL /* = new WATER_BILL() */,
        /*public static final*/ EXTRA_PAYMENT /* = new EXTRA_PAYMENT() */,
        /*public static final*/ GENERAL /* = new GENERAL() */;
        
        PaymentType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment.PaymentType> getEntries() {
            return null;
        }
    }
}