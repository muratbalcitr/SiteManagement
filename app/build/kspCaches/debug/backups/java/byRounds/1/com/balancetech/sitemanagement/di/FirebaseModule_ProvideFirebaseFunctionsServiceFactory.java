package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
import com.google.firebase.functions.FirebaseFunctions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class FirebaseModule_ProvideFirebaseFunctionsServiceFactory implements Factory<FirebaseFunctionsService> {
  private final Provider<FirebaseFunctions> functionsProvider;

  public FirebaseModule_ProvideFirebaseFunctionsServiceFactory(
      Provider<FirebaseFunctions> functionsProvider) {
    this.functionsProvider = functionsProvider;
  }

  @Override
  public FirebaseFunctionsService get() {
    return provideFirebaseFunctionsService(functionsProvider.get());
  }

  public static FirebaseModule_ProvideFirebaseFunctionsServiceFactory create(
      Provider<FirebaseFunctions> functionsProvider) {
    return new FirebaseModule_ProvideFirebaseFunctionsServiceFactory(functionsProvider);
  }

  public static FirebaseFunctionsService provideFirebaseFunctionsService(
      FirebaseFunctions functions) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideFirebaseFunctionsService(functions));
  }
}
