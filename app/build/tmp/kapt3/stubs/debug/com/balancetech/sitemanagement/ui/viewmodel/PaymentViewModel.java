package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u001aJL\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001aR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentRepository", "Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;", "feeRepository", "Lcom/balancetech/sitemanagement/data/repository/FeeRepository;", "extraPaymentRepository", "Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "authRepository", "Lcom/balancetech/sitemanagement/data/repository/AuthRepository;", "(Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;Lcom/balancetech/sitemanagement/data/repository/FeeRepository;Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;Lcom/balancetech/sitemanagement/data/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/PaymentUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getAllPayments", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getPaymentsByUnit", "unitId", "", "recordPayment", "", "amount", "", "paymentMethod", "description", "feeId", "extraPaymentId", "waterBillId", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PaymentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState> uiState = null;
    
    @javax.inject.Inject
    public PaymentViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getAllPayments() {
        return null;
    }
    
    public final void recordPayment(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, double amount, @org.jetbrains.annotations.NotNull
    java.lang.String paymentMethod, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String feeId, @org.jetbrains.annotations.Nullable
    java.lang.String extraPaymentId, @org.jetbrains.annotations.Nullable
    java.lang.String waterBillId) {
    }
}