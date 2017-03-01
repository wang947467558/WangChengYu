package com.wcy.education.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setFragmentView(), container, false);
        initView(view);
        initData(view);
        return view;
    }

    protected abstract int setFragmentView();

    protected abstract void initView(View view);

    protected abstract void initData(View view);
}
