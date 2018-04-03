package me.listenzz.componentization.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.listenzz.businessa.di.AModule;
import me.listenzz.businessb.di.BModule;
import me.listenzz.businessc.AccountManagerDelegate;
import me.listenzz.commonui.ActivityScope;
import me.listenzz.commonui.UIComponentFactory;
import me.listenzz.componentization.AccountManagerDelegateImpl;
import me.listenzz.componentization.MainActivity;
import me.listenzz.componentization.MainApplication;
import me.listenzz.componentization.UIComponentFactoryImpl;

@Module
public abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            AModule.class,
            BModule.class,
    })
    abstract MainActivity mainActivityInjector();

    @Binds
    @Singleton
    abstract Application application(MainApplication application);

    @Binds
    @Singleton
    abstract UIComponentFactory uiComponentFactory(UIComponentFactoryImpl uiComponentFactory);

    @Binds
    @Singleton
    abstract AccountManagerDelegate accountManagerDelegate(AccountManagerDelegateImpl delegate);

}
