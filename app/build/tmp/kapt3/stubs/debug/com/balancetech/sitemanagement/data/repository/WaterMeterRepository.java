package com.balancetech.sitemanagement.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ4\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0019\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dJ\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001e0\u001dJ\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u001bJ,\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010&J,\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006*"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/WaterMeterRepository;", "", "waterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "waterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "functionsService", "Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "(Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;)V", "createOrUpdateWaterMeter", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "unitId", "", "meterNumber", "unitPrice", "", "createOrUpdateWaterMeter-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWaterBill", "", "waterBillId", "deleteWaterBill-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterBills", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getAllWaterMeters", "getWaterBillsByUnit", "getWaterMeterByUnit", "recordPayment", "paymentAmount", "recordPayment-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordReading", "currentReading", "recordReading-0E7RQCE", "app_debug"})
public final class WaterMeterRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    
    @javax.inject.Inject
    public WaterMeterRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource) {
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