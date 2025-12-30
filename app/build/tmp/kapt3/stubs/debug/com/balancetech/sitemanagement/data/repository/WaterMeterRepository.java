package com.balancetech.sitemanagement.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ,\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "", "waterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "waterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "functionsService", "Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;", "(Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;)V", "createOrUpdateWaterMeter", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "unitId", "", "meterNumber", "unitPrice", "", "createOrUpdateWaterMeter-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterBills", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getAllWaterMeters", "getWaterBillsByUnit", "getWaterMeterByUnit", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordPayment", "waterBillId", "paymentAmount", "recordPayment-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordReading", "currentReading", "recordReading-0E7RQCE", "app_debug"})
public final class WaterMeterRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService = null;
    
    public WaterMeterRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> getAllWaterMeters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getWaterMeterByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterMeter> $completion) {
        return null;
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
}