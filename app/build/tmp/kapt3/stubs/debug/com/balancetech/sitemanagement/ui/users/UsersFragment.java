package com.balancetech.sitemanagement.ui.users;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u0015H\u0016J\u001a\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u00061"}, d2 = {"Lcom/balancetech/sitemanagement/ui/users/UsersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/FragmentUsersBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/FragmentUsersBinding;", "filePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "userAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/UserAdapter;", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/UserViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/UserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "deleteUser", "", "user", "Lcom/balancetech/sitemanagement/data/entity/User;", "editUser", "exportUnitsToExcel", "exportUsersToExcel", "importFromExcel", "uri", "Landroid/net/Uri;", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "openFilePicker", "setupFab", "setupRecyclerView", "setupToolbar", "shareFile", "showAddUserDialog", "showUserDetails", "app_debug"})
public final class UsersFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.FragmentUsersBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.balancetech.sitemanagement.ui.adapter.UserAdapter userAdapter;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> filePickerLauncher = null;
    
    public UsersFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.FragmentUsersBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.UserViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupFab() {
    }
    
    private final void openFilePicker() {
    }
    
    private final void importFromExcel(android.net.Uri uri) {
    }
    
    private final void exportUsersToExcel() {
    }
    
    private final void exportUnitsToExcel() {
    }
    
    private final void shareFile(android.net.Uri uri) {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showAddUserDialog() {
    }
    
    private final void showUserDetails(com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    private final void editUser(com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    private final void deleteUser(com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}