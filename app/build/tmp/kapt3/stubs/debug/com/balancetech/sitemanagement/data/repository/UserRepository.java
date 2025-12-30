package com.balancetech.sitemanagement.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JZ\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u0017\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u001bJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u001b2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u001b2\u0006\u0010\u0012\u001a\u00020\u000bJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/UserRepository;", "", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "(Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;)V", "createUser", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/User;", "email", "", "password", "name", "phone", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "apartmentId", "unitId", "createUser-eH_QyT8", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/UserRole;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "", "user", "deleteUser-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "getUsersByRole", "getUsersByUnit", "updateUser", "updateUser-gIAlu-s", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    
    @javax.inject.Inject
    public UserRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    /**
     * Get all active users (residents)
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getAllActiveUsers() {
        return null;
    }
    
    /**
     * Get users by role
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByRole(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.UserRole role) {
        return null;
    }
    
    /**
     * Get users by unit
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
}