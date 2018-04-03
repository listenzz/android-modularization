package me.listenzz.componentization;

import android.os.Bundle;

import javax.inject.Inject;

import me.listenzz.commonui.BaseActivity;
import me.listenzz.commonui.BaseFragment;
import me.listenzz.commonui.UIComponentFactory;
import me.listenzz.navigation.NavigationFragment;

public class MainActivity extends BaseActivity {

    @Inject
    UIComponentFactory uiComponentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            BaseFragment rootFragment = uiComponentFactory.createFragment("A");
            NavigationFragment navigationFragment = new NavigationFragment();
            navigationFragment.setRootFragment(rootFragment);
            setRootFragment(navigationFragment);
        }
    }

}
