package me.listenzz.businessa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import me.listenzz.common_api.Account;
import me.listenzz.common_api.AccountManager;
import me.listenzz.commonui.BaseFragment;
import me.listenzz.commonui.UIComponentFactory;

public class AFragment extends BaseFragment {

    @Inject
    UIComponentFactory uiComponentFactory;

    @Inject
    AccountManager accountManager;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.a_fragment_a, container, false);

        root.findViewById(R.id.to_a_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块内跳转，直接 new 即可
                BaseFragment fragment = new BFragment();
                getNavigationFragment().pushFragment(fragment);
            }
        });

        root.findViewById(R.id.to_b_e).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块间跳转，需要通过工厂方法来获取目标页面
                BaseFragment fragment = uiComponentFactory.createFragment("E");
                getNavigationFragment().pushFragment(fragment);
            }
        });

        root.findViewById(R.id.to_b_f).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseFragment fragment = uiComponentFactory.createFragment("F");
                getNavigationFragment().pushFragment(fragment);
            }
        });

        textView = root.findViewById(R.id.text);

        root.findViewById(R.id.to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountManager.invalidate();
            }
        });

        return root;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("A 模块 A 页面");
        Account account =  accountManager.login("listenzz", "123456");
        textView.setText("用户名：" +account.username + "\n" + "登录方式：" + account.type);
    }

}
