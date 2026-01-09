package com.balancetech.sitemanagement.ui.watermeter;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\u001a\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/balancetech/sitemanagement/ui/watermeter/WaterMeterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/balancetech/sitemanagement/databinding/FragmentWaterMeterBinding;", "binding", "getBinding", "()Lcom/balancetech/sitemanagement/databinding/FragmentWaterMeterBinding;", "importFileLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "viewModel", "Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterViewModel;", "getViewModel", "()Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "waterBillAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/WaterBillAdapter;", "waterMeterAdapter", "Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter;", "deleteWaterBill", "", "waterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "exportWaterMetersToExcel", "importWaterMetersFromExcel", "uri", "Landroid/net/Uri;", "loadWaterBills", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "openFilePicker", "setupFab", "setupRecyclerViews", "setupTabs", "setupToolbar", "shareFile", "showAddWaterMeterDialog", "showPaymentDialog", "showReadingDialog", "unitId", "", "previousReading", "", "showWaterBillDetails", "showWaterMeterDetails", "waterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "app_debug"})
public final class WaterMeterFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.balancetech.sitemanagement.databinding.FragmentWaterMeterBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter waterMeterAdapter;
    private com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter waterBillAdapter;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> importFileLauncher = null;
    
    public WaterMeterFragment() {
        super();
    }
    
    private final com.balancetech.sitemanagement.databinding.FragmentWaterMeterBinding getBinding() {
        return null;
    }
    
    private final com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel getViewModel() {
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
    
    private final void openFilePicker() {
    }
    
    private final void importWaterMetersFromExcel(android.net.Uri uri) {
    }
    
    private final void exportWaterMetersToExcel() {
    }
    
    private final void shareFile(android.net.Uri uri) {
    }
    
    private final void setupTabs() {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void setupFab() {
    }
    
    private final void showAddWaterMeterDialog() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showReadingDialog(java.lang.String unitId, double previousReading) {
    }
    
    private final void showPaymentDialog(com.balancetech.sitemanagement.data.entity.WaterBill waterBill) {
    }
    
    private final void loadWaterBills() {
    }
    
    private final void showWaterMeterDetails(com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter) {
    }
    
    private final void showWaterBillDetails(com.balancetech.sitemanagement.data.entity.WaterBill waterBill) {
    }
    
    private final void deleteWaterBill(com.balancetech.sitemanagement.data.entity.WaterBill waterBill) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}