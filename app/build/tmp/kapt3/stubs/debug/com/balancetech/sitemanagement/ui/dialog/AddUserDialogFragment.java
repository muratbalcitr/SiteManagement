package com.balancetech.sitemanagement.ui.dialog;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0014\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u001a\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/balancetech/sitemanagement/ui/dialog/AddUserDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/DialogAddUserBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/DialogAddUserBinding;", "onUserAdded", "Lkotlin/Function0;", "", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/UserViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/UserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addUser", "observeViewModel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setOnUserAddedListener", "listener", "setupViews", "app_debug"})
public final class AddUserDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.DialogAddUserBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onUserAdded;
    
    public AddUserDialogFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.DialogAddUserBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.UserViewModel getViewModel() {
        return null;
    }
    
    public final void setOnUserAddedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupViews() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void addUser() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}