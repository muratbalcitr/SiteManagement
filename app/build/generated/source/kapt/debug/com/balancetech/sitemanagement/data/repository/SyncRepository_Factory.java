package com.balancetech.sitemanagement.data.repository;

import com.balancetech.sitemanagement.data.dao.UserUnitDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SyncRepository_Factory implements Factory<SyncRepository> {
  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  private final Provider<UserUnitDao> userUnitDaoProvider;

  private final Provider<FirebaseFunctionsService> functionsServiceProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  public SyncRepository_Factory(Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<UserUnitDao> userUnitDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.userUnitDaoProvider = userUnitDaoProvider;
    this.functionsServiceProvider = functionsServiceProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public SyncRepository get() {
    return newInstance(localDataSourceProvider.get(), remoteDataSourceProvider.get(), userUnitDaoProvider.get(), functionsServiceProvider.get(), firestoreProvider.get());
  }

  public static SyncRepository_Factory create(Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<UserUnitDao> userUnitDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new SyncRepository_Factory(localDataSourceProvider, remoteDataSourceProvider, userUnitDaoProvider, functionsServiceProvider, firestoreProvider);
  }

  public static SyncRepository newInstance(LocalDataSource localDataSource,
      RemoteDataSource remoteDataSource, UserUnitDao userUnitDao,
      FirebaseFunctionsService functionsService, FirebaseFirestore firestore) {
    return new SyncRepository(localDataSource, remoteDataSource, userUnitDao, functionsService, firestore);
  }
}
