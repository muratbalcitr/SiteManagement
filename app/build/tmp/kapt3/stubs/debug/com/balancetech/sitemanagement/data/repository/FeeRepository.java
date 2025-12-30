package com.balancetech.sitemanagement.data.repository;

/**
 * FeeRepository with offline-first strategy
 * Writes to local database first, then syncs to Firebase via Functions
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00019B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJL\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJD\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110%0$J*\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110%0$2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\"\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110%0$2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110%0$2\u0006\u0010\u0014\u001a\u00020\u0013J,\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b2\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002010\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b5\u00103J\u0016\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006:"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/FeeRepository;", "", "feeDao", "Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "functionsService", "Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;", "userDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "(Lcom/balancetech/sitemanagement/data/dao/FeeDao;Lcom/balancetech/sitemanagement/data/dao/UnitDao;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;Lcom/balancetech/sitemanagement/data/dao/UserDao;)V", "createFee", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "apartmentId", "", "unitId", "month", "", "year", "amount", "", "dueDate", "", "createFee-bMdYcbs", "(Ljava/lang/String;Ljava/lang/String;IIDJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFeesForAllUnits", "Lcom/balancetech/sitemanagement/data/repository/FeeRepository$CreateFeesResult;", "baseAmount", "createFeesForAllUnits-hUnOzRk", "(Ljava/lang/String;IIDJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFees", "Lkotlinx/coroutines/flow/Flow;", "", "getFeesByMonth", "getFeesByStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getFeesByUnit", "recordPayment", "feeId", "paymentAmount", "recordPayment-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncFromRemote", "", "syncFromRemote-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncToRemote", "syncToRemote-IoAF18A", "updateFee", "fee", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CreateFeesResult", "app_debug"})
public final class FeeRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.FeeDao feeDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UnitDao unitDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UserDao userDao = null;
    
    public FeeRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.FeeDao feeDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UnitDao unitDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UserDao userDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getAllFees() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/FeeRepository$CreateFeesResult;", "", "createdCount", "", "updatedCount", "fees", "", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "(IILjava/util/List;)V", "getCreatedCount", "()I", "getFees", "()Ljava/util/List;", "getUpdatedCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class CreateFeesResult {
        private final int createdCount = 0;
        private final int updatedCount = 0;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees = null;
        
        public CreateFeesResult(int createdCount, int updatedCount, @org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees) {
            super();
        }
        
        public final int getCreatedCount() {
            return 0;
        }
        
        public final int getUpdatedCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> getFees() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.data.repository.FeeRepository.CreateFeesResult copy(int createdCount, int updatedCount, @org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}