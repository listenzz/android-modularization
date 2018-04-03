package me.listenzz.commonui;

import android.content.Context;

import dagger.android.support.AndroidSupportInjection;
import me.listenzz.navigation.AwesomeFragment;

public abstract class BaseFragment extends AwesomeFragment {

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
