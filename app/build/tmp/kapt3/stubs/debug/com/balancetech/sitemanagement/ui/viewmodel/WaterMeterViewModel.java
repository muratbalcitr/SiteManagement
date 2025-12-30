package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00150\u0014J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterViewModel;", "Landroidx/lifecycle/ViewModel;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "(Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createOrUpdateWaterMeter", "", "unitId", "", "meterNumber", "unitPrice", "", "getAllWaterBills", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getWaterBillsByUnit", "getWaterMeterByUnit", "recordPayment", "waterBillId", "paymentAmount", "recordReading", "currentReading", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class WaterMeterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState> uiState = null;
    
    @javax.inject.Inject
    public WaterMeterViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> getAllWaterMeters() {
        return null;
    }
    
    public final void getWaterMeterByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> getAllWaterBills() {
        return null;
    }
    
    public final void createOrUpdateWaterMeter(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    java.lang.String meterNumber, double unitPrice) {
    }
    
    public final void recordReading(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, double currentReading) {
    }
    
    public final void recordPayment(@org.jetbrains.annotations.NotNull
    java.lang.String waterBillId, double paymentAmount) {
    }
}