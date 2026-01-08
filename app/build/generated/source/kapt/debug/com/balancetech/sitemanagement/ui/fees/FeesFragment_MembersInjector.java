package com.balancetech.sitemanagement.ui.fees;

import com.balancetech.sitemanagement.data.repository.SyncRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class FeesFragment_MembersInjector implements MembersInjector<FeesFragment> {
  private final Provider<SyncRepository> syncRepositoryProvider;

  public FeesFragment_MembersInjector(Provider<SyncRepository> syncRepositoryProvider) {
    this.syncRepositoryProvider = syncRepositoryProvider;
  }

  public static MembersInjector<FeesFragment> create(
      Provider<SyncRepository> syncRepositoryProvider) {
    return new FeesFragment_MembersInjector(syncRepositoryProvider);
  }

  @Override
  public void injectMembers(FeesFragment instance) {
    injectSyncRepository(instance, syncRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.balancetech.sitemanagement.ui.fees.FeesFragment.syncRepository")
  public static void injectSyncRepository(FeesFragment instance, SyncRepository syncRepository) {
    instance.syncRepository = syncRepository;
  }
}
