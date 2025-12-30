package com.balancetech.sitemanagement.data.service;

import com.google.firebase.functions.FirebaseFunctions;
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
public final class FirebaseFunctionsService_Factory implements Factory<FirebaseFunctionsService> {
  private final Provider<FirebaseFunctions> functionsProvider;

  public FirebaseFunctionsService_Factory(Provider<FirebaseFunctions> functionsProvider) {
    this.functionsProvider = functionsProvider;
  }

  @Override
  public FirebaseFunctionsService get() {
    return newInstance(functionsProvider.get());
  }

  public static FirebaseFunctionsService_Factory create(
      Provider<FirebaseFunctions> functionsProvider) {
    return new FirebaseFunctionsService_Factory(functionsProvider);
  }

  public static FirebaseFunctionsService newInstance(FirebaseFunctions functions) {
    return new FirebaseFunctionsService(functions);
  }
}
