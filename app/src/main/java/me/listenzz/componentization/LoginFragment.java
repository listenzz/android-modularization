package me.listenzz.componentization;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import me.listenzz.commonui.BaseFragment;

public class LoginFragment extends BaseFragment {

    @Inject
    Application application;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        root.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(application, "登录成功！！！", Toast.LENGTH_LONG).show();
                dismissFragment();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("登录界面");
        setToolbarLeftButton(null, "取消", true, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissFragment();
            }
        });
    }
}
