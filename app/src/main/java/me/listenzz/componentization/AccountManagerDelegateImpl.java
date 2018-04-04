package me.listenzz.componentization;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.listenzz.common_api.AccountManagerDelegate;
import me.listenzz.navigation.NavigationFragment;

@Singleton
public class AccountManagerDelegateImpl implements AccountManagerDelegate {

    private MainApplication application;

    @Inject
    public AccountManagerDelegateImpl(MainApplication application) {
        this.application = application;
    }

    @Override
    public void onInvalidation() {
        Log.w("Dagger", "onInvalidation");
        if (application.mainActivity != null) {
            NavigationFragment navigationFragment = new NavigationFragment();
            navigationFragment.setRootFragment(new LoginFragment());
            application.mainActivity.presentFragment(navigationFragment);
        } else {
            // do something
        }
    }
}
