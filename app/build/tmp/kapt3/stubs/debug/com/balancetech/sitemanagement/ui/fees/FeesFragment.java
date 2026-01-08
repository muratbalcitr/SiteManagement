package com.balancetech.sitemanagement.ui.fees;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006?"}, d2 = {"Lcom/balancetech/sitemanagement/ui/fees/FeesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/FragmentFeesBinding;", "adapter", "Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/FragmentFeesBinding;", "currentFilter", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "isMonthView", "", "monthAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/FeeMonthAdapter;", "searchQuery", "", "syncRepository", "Lcom/balancetech/sitemanagement/data/repository/SyncRepository;", "getSyncRepository", "()Lcom/balancetech/sitemanagement/data/repository/SyncRepository;", "setSyncRepository", "(Lcom/balancetech/sitemanagement/data/repository/SyncRepository;)V", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/FeeViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/FeeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "exportToExcel", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "performSearch", "query", "setupFab", "setupRecyclerView", "setupTabs", "setupToolbar", "shareFile", "uri", "Landroid/net/Uri;", "showCreateFeeDialog", "showCreateFeesForAllUnitsDialog", "showMonthDetails", "summary", "Lcom/balancetech/sitemanagement/data/model/FeeMonthSummary;", "showPaymentDialog", "feeId", "remainingAmount", "", "syncFeesFromFirebase", "app_debug"})
public final class FeesFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.FragmentFeesBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.balancetech.sitemanagement.data.repository.SyncRepository syncRepository;
    private com.balancetech.sitemanagement.ui.adapter.FeeAdapter adapter;
    private com.balancetech.sitemanagement.ui.adapter.FeeMonthAdapter monthAdapter;
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.data.model.PaymentStatus currentFilter;
    private boolean isMonthView = true;
    @org.jetbrains.annotations.NotNull
    private java.lang.String searchQuery = "";
    
    public FeesFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.FragmentFeesBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.repository.SyncRepository getSyncRepository() {
        return null;
    }
    
    public final void setSyncRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.SyncRepository p0) {
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
    
    private final void syncFeesFromFirebase() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void performSearch(java.lang.String query) {
    }
    
    private final void setupTabs() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void showMonthDetails(com.balancetech.sitemanagement.data.model.FeeMonthSummary summary) {
    }
    
    private final void observeViewModel() {
    }
    
    private final void setupFab() {
    }
    
    private final void showCreateFeesForAllUnitsDialog() {
    }
    
    private final void exportToExcel() {
    }
    
    private final void shareFile(android.net.Uri uri) {
    }
    
    private final void showCreateFeeDialog() {
    }
    
    private final void showPaymentDialog(java.lang.String feeId, double remainingAmount) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}