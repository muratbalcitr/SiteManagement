package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/ReportsViewModel;", "Landroidx/lifecycle/ViewModel;", "feeRepository", "Lcom/balancetech/sitemanagement/data/repository/FeeRepository;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "(Lcom/balancetech/sitemanagement/data/repository/FeeRepository;Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;)V", "getMonthlyPaymentSummary", "Lkotlinx/coroutines/flow/Flow;", "", "", "", "getTotalUnpaidFees", "getTotalUnpaidWaterBills", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ReportsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    
    @javax.inject.Inject
    public ReportsViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalUnpaidFees() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalUnpaidWaterBills() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.Map<java.lang.String, java.lang.Double>> getMonthlyPaymentSummary() {
        return null;
    }
}