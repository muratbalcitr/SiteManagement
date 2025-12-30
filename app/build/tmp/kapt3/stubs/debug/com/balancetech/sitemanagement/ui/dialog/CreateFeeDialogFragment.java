package com.balancetech.sitemanagement.ui.dialog;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0014\u0010\u001d\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/CreateFeeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/DialogCreateFeeBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/DialogCreateFeeBinding;", "onFeeCreatedListener", "Lkotlin/Function0;", "", "selectedDueDate", "", "selectedMonth", "", "selectedYear", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/FeeViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/FeeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createFee", "observeViewModel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setOnFeeCreatedListener", "listener", "setupButtons", "setupDueDatePicker", "setupMonthSpinner", "setupYearSpinner", "updateDueDateButton", "app_debug"})
public final class CreateFeeDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.DialogCreateFeeBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onFeeCreatedListener;
    private long selectedDueDate;
    private int selectedMonth;
    private int selectedYear;
    
    public CreateFeeDialogFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.DialogCreateFeeBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupMonthSpinner() {
    }
    
    private final void setupYearSpinner() {
    }
    
    private final void setupDueDatePicker() {
    }
    
    private final void updateDueDateButton() {
    }
    
    private final void setupButtons() {
    }
    
    private final void createFee() {
    }
    
    private final void observeViewModel() {
    }
    
    public final void setOnFeeCreatedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}