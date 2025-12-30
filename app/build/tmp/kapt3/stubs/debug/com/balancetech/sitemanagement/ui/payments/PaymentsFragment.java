package com.balancetech.sitemanagement.ui.payments;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006&"}, d2 = {"Lcom/balancetech/sitemanagement/ui/payments/PaymentsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/FragmentPaymentsBinding;", "adapter", "Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/FragmentPaymentsBinding;", "currentFilter", "Lcom/balancetech/sitemanagement/ui/payments/PaymentsFragment$PaymentFilter;", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupFilterButtons", "setupRecyclerView", "showPaymentDetails", "payment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "updateFilterButtons", "PaymentFilter", "app_debug"})
public final class PaymentsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.FragmentPaymentsBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.balancetech.sitemanagement.ui.adapter.PaymentAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private com.balancetech.sitemanagement.ui.payments.PaymentsFragment.PaymentFilter currentFilter = com.balancetech.sitemanagement.ui.payments.PaymentsFragment.PaymentFilter.ALL;
    
    public PaymentsFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.FragmentPaymentsBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel getViewModel() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setupFilterButtons() {
    }
    
    private final void updateFilterButtons() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showPaymentDetails(com.balancetech.sitemanagement.data.entity.Payment payment) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/balancetech/sitemanagement/ui/payments/PaymentsFragment$PaymentFilter;", "", "(Ljava/lang/String;I)V", "ALL", "FEE", "EXTRA_PAYMENT", "WATER_BILL", "GENERAL", "app_debug"})
    static enum PaymentFilter {
        /*public static final*/ ALL /* = new ALL() */,
        /*public static final*/ FEE /* = new FEE() */,
        /*public static final*/ EXTRA_PAYMENT /* = new EXTRA_PAYMENT() */,
        /*public static final*/ WATER_BILL /* = new WATER_BILL() */,
        /*public static final*/ GENERAL /* = new GENERAL() */;
        
        PaymentFilter() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.balancetech.sitemanagement.ui.payments.PaymentsFragment.PaymentFilter> getEntries() {
            return null;
        }
    }
}