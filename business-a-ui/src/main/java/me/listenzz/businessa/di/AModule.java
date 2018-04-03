package me.listenzz.businessa.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.listenzz.businessa.AFragment;
import me.listenzz.businessa.BFragment;
import me.listenzz.businessa.CFragment;


@Module
public abstract class AModule {

    @ContributesAndroidInjector
    abstract AFragment aFragmentInjector();

    @ContributesAndroidInjector
    abstract BFragment bFragmentInjector();

    @ContributesAndroidInjector
    abstract CFragment cFragmentInjector();

}

