package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/UserDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "feeRepository", "Lcom/balancetech/sitemanagement/data/repository/FeeRepository;", "extraPaymentRepository", "Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "waterMeterRepository", "Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "paymentRepository", "Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "(Lcom/balancetech/sitemanagement/data/repository/FeeRepository;Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;Lcom/balancetech/sitemanagement/data/repository/PaymentRepository;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;)V", "getExtraPaymentsByUnit", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "unitId", "", "getFeesByUnit", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "getPaymentsByUnit", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getTotalDebt", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUserById", "Lcom/balancetech/sitemanagement/data/entity/User;", "userId", "getWaterBillsByUnit", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class UserDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    
    @javax.inject.Inject
    public UserDetailViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.FeeRepository feeRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository extraPaymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.WaterMeterRepository waterMeterRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUnitById(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getExtraPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalDebt(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
}