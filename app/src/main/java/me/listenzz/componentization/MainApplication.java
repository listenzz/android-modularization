package me.listenzz.componentization;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import me.listenzz.businessa.AFragment;
import me.listenzz.businessb.EFragment;
import me.listenzz.businessb.FFragment;
import me.listenzz.componentization.di.AppComponent;
import me.listenzz.componentization.di.DaggerAppComponent;


public class MainApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    UIComponentRegistry uiComponentRegistry;

    MainActivity mainActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new LifecycleListener());

        AppComponent.Builder builder = DaggerAppComponent.builder();
        builder.seedInstance(this);
        builder.build().inject(this);

        uiComponentRegistry.registerModule("A", AFragment.class);
        uiComponentRegistry.registerModule("E", EFragment.class);
        uiComponentRegistry.registerModule("F", FFragment.class);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    class LifecycleListener implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity instanceof MainActivity) {
                mainActivity = (MainActivity) activity;
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MainActivity) {
                mainActivity = null;
            }
        }
    }

}
