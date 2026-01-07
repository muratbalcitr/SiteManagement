package com.balancetech.sitemanagement.ui.dialog;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0014\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/CreateExtraPaymentDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "APARTMENT_ID", "", "_binding", "Lcom/balancetech/sitemanagement/databinding/DialogCreateExtraPaymentBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/DialogCreateExtraPaymentBinding;", "onExtraPaymentCreatedListener", "Lkotlin/Function0;", "", "selectedDueDate", "", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/ExtraPaymentViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/ExtraPaymentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createExtraPayment", "observeViewModel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setOnExtraPaymentCreatedListener", "listener", "setupButtons", "setupDueDatePicker", "setupTypeSpinner", "updateDueDateButton", "app_debug"})
public final class CreateExtraPaymentDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.DialogCreateExtraPaymentBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onExtraPaymentCreatedListener;
    private long selectedDueDate;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String APARTMENT_ID = "apt-001";
    
    public CreateExtraPaymentDialogFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.DialogCreateExtraPaymentBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupTypeSpinner() {
    }
    
    private final void setupDueDatePicker() {
    }
    
    private final void updateDueDateButton() {
    }
    
    private final void setupButtons() {
    }
    
    private final void createExtraPayment() {
    }
    
    private final void observeViewModel() {
    }
    
    public final void setOnExtraPaymentCreatedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}