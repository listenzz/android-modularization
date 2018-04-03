package me.listenzz.businessc.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import me.listenzz.businessc.AccountManagerImpl;
import me.listenzz.common_api.AccountManager;

@Module
public abstract class CModule {

    @Binds
    @Singleton
    abstract AccountManager provideAccountManager(AccountManagerImpl accountManager);

}
