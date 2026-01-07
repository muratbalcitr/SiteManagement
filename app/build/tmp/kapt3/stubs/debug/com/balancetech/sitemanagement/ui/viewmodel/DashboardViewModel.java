package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'J\u000e\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\'J\u0006\u0010*\u001a\u00020)R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/balancetech/sitemanagement/data/repository/AuthRepository;", "feeRepository", "Lcom/balancetech/sitemanagement/data/repository/FeeRepository;", "paymentRepository", "Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;", "extraPaymentRepository", "Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "syncRepository", "Lcom/balancetech/sitemanagement/data/repository/SyncRepository;", "(Lcom/balancetech/sitemanagement/data/repository/AuthRepository;Lcom/balancetech/sitemanagement/data/repository/FeeRepository;Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;Lcom/balancetech/sitemanagement/data/repository/SyncRepository;)V", "_syncState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/SyncState;", "_uiState", "Lcom/balancetech/sitemanagement/ui/viewmodel/DashboardUiState;", "currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/balancetech/sitemanagement/data/entity/User;", "getCurrentUser", "()Lkotlinx/coroutines/flow/StateFlow;", "remainingPayment", "Lkotlinx/coroutines/flow/Flow;", "", "getRemainingPayment", "()Lkotlinx/coroutines/flow/Flow;", "syncState", "getSyncState", "totalCredit", "getTotalCredit", "totalDebt", "getTotalDebt", "uiState", "getUiState", "unitId", "", "loadDashboardData", "", "syncToFirebase", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.SyncRepository syncRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.DashboardUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.DashboardUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.SyncState> _syncState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.SyncState> syncState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.data.entity.User> currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Double> totalDebt = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Double> totalCredit = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Double> remainingPayment = null;
    
    @javax.inject.Inject
    public DashboardViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.SyncRepository syncRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.DashboardUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.SyncState> getSyncState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.data.entity.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalDebt(@org.jetbrains.annotations.Nullable
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalDebt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalCredit(@org.jetbrains.annotations.Nullable
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalCredit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getRemainingPayment(@org.jetbrains.annotations.Nullable
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getRemainingPayment() {
        return null;
    }
    
    public final void loadDashboardData(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
    }
    
    public final void syncToFirebase() {
    }
}