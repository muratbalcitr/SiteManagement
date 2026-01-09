package com.balancetech.sitemanagement.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/SyncRepository;", "", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "userUnitDao", "Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;", "functionsService", "Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;Lcom/balancetech/sitemanagement/data/service/FirebaseFunctionsService;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "syncAllToFirebase", "Lkotlin/Result;", "", "syncAllToFirebase-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncFromFirebase", "apartmentId", "syncFromFirebase-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SyncRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    
    @javax.inject.Inject
    public SyncRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.service.FirebaseFunctionsService functionsService, @org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
}