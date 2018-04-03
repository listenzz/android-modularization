package me.listenzz.businessb.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.listenzz.businessb.EFragment;
import me.listenzz.businessb.FFragment;
import me.listenzz.businessb.GFragment;

@Module
public abstract class BModule {

    @ContributesAndroidInjector
    abstract EFragment eFragmentInjector();

    @ContributesAndroidInjector
    abstract FFragment fFragmentInjector();

    @ContributesAndroidInjector
    abstract GFragment gFragmentInjector();

}
