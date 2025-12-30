package com.balancetech.sitemanagement.ui.users;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\tH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001bH\u0016J\u001a\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J \u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/balancetech/sitemanagement/ui/users/UserDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/FragmentUserDetailBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/FragmentUserDetailBinding;", "currentUnitId", "", "currentUser", "Lcom/balancetech/sitemanagement/data/entity/User;", "extraPaymentAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/ExtraPaymentAdapter;", "feeAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter;", "paymentAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter;", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/UserDetailViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/UserDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "waterBillAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/WaterBillAdapter;", "loadUnitData", "", "unitId", "observeViewModel", "userId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRecyclerView", "setupTabs", "showExtraPayments", "showFees", "showPaymentDialog", "id", "remainingAmount", "", "paymentType", "Lcom/balancetech/sitemanagement/ui/dialog/PaymentEntryDialogFragment$PaymentType;", "showPayments", "showWaterBills", "updateUserInfo", "user", "Companion", "app_debug"})
public final class UserDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.FragmentUserDetailBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.balancetech.sitemanagement.ui.adapter.FeeAdapter feeAdapter;
    private com.balancetech.sitemanagement.ui.adapter.ExtraPaymentAdapter extraPaymentAdapter;
    private com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter waterBillAdapter;
    private com.balancetech.sitemanagement.ui.adapter.PaymentAdapter paymentAdapter;
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.data.entity.User currentUser;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currentUnitId;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.ui.users.UserDetailFragment.Companion Companion = null;
    
    public UserDetailFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.FragmentUserDetailBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel getViewModel() {
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
    
    private final void setupTabs() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void observeViewModel(java.lang.String userId) {
    }
    
    private final void updateUserInfo(com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    private final void loadUnitData(java.lang.String unitId) {
    }
    
    private final void showFees() {
    }
    
    private final void showExtraPayments() {
    }
    
    private final void showWaterBills() {
    }
    
    private final void showPayments() {
    }
    
    private final void showPaymentDialog(java.lang.String id, double remainingAmount, com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment.PaymentType paymentType) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/balancetech/sitemanagement/ui/users/UserDetailFragment$Companion;", "", "()V", "ARG_USER_ID", "", "newInstance", "Lcom/balancetech/sitemanagement/ui/users/UserDetailFragment;", "userId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.ui.users.UserDetailFragment newInstance(@org.jetbrains.annotations.NotNull
        java.lang.String userId) {
            return null;
        }
    }
}