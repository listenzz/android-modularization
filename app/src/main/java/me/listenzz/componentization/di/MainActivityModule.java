package me.listenzz.componentization.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.listenzz.componentization.LoginFragment;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract LoginFragment loginFragmentInjector();

}
