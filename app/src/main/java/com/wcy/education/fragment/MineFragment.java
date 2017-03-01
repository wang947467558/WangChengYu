package com.wcy.education.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wcy.education.R;
import com.wcy.education.base.BaseFragment;
import com.wcy.education.view.Image3DSwitchView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class MineFragment extends BaseFragment {
    private Image3DSwitchView image3DSwitchView;
    private ImageView image1;

    private List<String> imageUrls;

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        imageUrls = new ArrayList<>();
        image3DSwitchView = (Image3DSwitchView) view.findViewById(R.id.image_switch_view);
        image1 = (ImageView) view.findViewById(R.id.image1);
        image3DSwitchView.startPlay();
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dfdaf", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData(View view) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        image3DSwitchView.clear();
    }
}
