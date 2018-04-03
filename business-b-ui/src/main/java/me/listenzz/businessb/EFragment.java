package me.listenzz.businessb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.listenzz.commonui.BaseFragment;

public class EFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.b_fragment_e, container, false);

        root.findViewById(R.id.to_b_f).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块内跳转，直接 new 即可
                BaseFragment fragment = new FFragment();
                getNavigationFragment().pushFragment(fragment);
            }
        });

        root.findViewById(R.id.to_b_g).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块内跳转，直接 new 即可
                BaseFragment fragment = new GFragment();
                getNavigationFragment().pushFragment(fragment);
            }
        });

        return root;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("B 模块 E 页面");
    }
}
