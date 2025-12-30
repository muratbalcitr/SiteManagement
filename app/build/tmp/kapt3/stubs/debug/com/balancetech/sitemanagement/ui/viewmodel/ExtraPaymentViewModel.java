package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JJ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006$"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/ExtraPaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "extraPaymentRepository", "Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "(Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/ExtraPaymentUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createExtraPayment", "", "apartmentId", "", "unitId", "title", "description", "amount", "", "type", "Lcom/balancetech/sitemanagement/data/model/ExtraPaymentType;", "installmentCount", "", "dueDate", "", "getAllExtraPayments", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "getBuildingWideExtraPayments", "getExtraPaymentsByUnit", "recordPayment", "extraPaymentId", "paymentAmount", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ExtraPaymentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState> uiState = null;
    
    @javax.inject.Inject
    public ExtraPaymentViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getExtraPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getBuildingWideExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getAllExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
        return null;
    }
    
    public final void createExtraPayment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.Nullable
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String description, double amount, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.ExtraPaymentType type, int installmentCount, long dueDate) {
    }
    
    public final void recordPayment(@org.jetbrains.annotations.NotNull
    java.lang.String extraPaymentId, double paymentAmount) {
    }
}