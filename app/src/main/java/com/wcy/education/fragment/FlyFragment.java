package com.wcy.education.fragment;

import android.view.View;
import android.widget.TextView;

import com.wcy.education.R;
import com.wcy.education.activity.Main2Activity;
import com.wcy.education.base.BaseFragment;
import com.wcy.education.utils.IntentUtils;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class FlyFragment extends BaseFragment {
    private TextView fly;

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_fly;
    }

    @Override
    protected void initView(View view) {
        fly = (TextView) view.findViewById(R.id.fly);
        fly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intent(getActivity(), Main2Activity.class);
            }
        });

    }

    @Override
    protected void initData(View view) {

    }


}
