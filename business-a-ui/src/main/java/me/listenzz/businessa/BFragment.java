package me.listenzz.businessa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import me.listenzz.commonui.BaseFragment;

public class BFragment extends BaseFragment {

    @Inject
    BViewModel viewModel;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.a_fragment_b, container, false);

        root.findViewById(R.id.to_a_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseFragment fragment = new CFragment();
                getNavigationFragment().pushFragment(fragment);
            }
        });

        textView = root.findViewById(R.id.text);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //viewModel = ViewModelProviders.of(getActivity()).get(BViewModel.class);

        setTitle("A 模块 B 页面");
        textView.setText("今晚吃啥？\n" +viewModel.currentFood());
    }
}
