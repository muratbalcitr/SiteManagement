package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0\u001fJ\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001a0\u001fJ\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a0\u001f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010%\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\u001aJ\u0016\u0010\'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0016J\u0016\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterViewModel;", "Landroidx/lifecycle/ViewModel;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "(Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/WaterMeterUiState;", "getLocalDataSource", "()Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createOrUpdateWaterMeter", "", "unitId", "", "meterNumber", "unitPrice", "", "deleteWaterBill", "waterBillId", "getAllUnits", "", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "apartmentId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterBills", "Lkotlinx/coroutines/flow/Flow;", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getWaterBillsByUnit", "getWaterMeterByUnit", "importWaterMeters", "waterMeters", "recordPayment", "paymentAmount", "recordReading", "currentReading", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class WaterMeterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState> uiState = null;
    
    @javax.inject.Inject
    public WaterMeterViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.datasource.LocalDataSource getLocalDataSource() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllUnits(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> $completion) {
        return null;
    }
    
    public final void importWaterMeters(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter> waterMeters) {
    }
    
    public final void deleteWaterBill(@org.jetbrains.annotations.NotNull
    java.lang.String waterBillId) {
    }
}