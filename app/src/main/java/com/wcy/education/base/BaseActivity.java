package com.wcy.education.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ab.activity.AbActivity;
import com.wcy.education.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public abstract class BaseActivity extends AbActivity {
    protected final int ZERO = 0;
    private TextView tv_left, tv_center, tv_right;
    private ImageView iv_left, iv_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        //butterKnife初始化
        ButterKnife.bind(this);
        titleView();
        initView();
        initData();
    }

    private void titleView() {
        tv_right = (TextView) findViewById(R.id.tv_right);
        tv_center = (TextView) findViewById(R.id.tv_center);
        tv_left = (TextView) findViewById(R.id.tv_left);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
    }


    /**
     * 子类回调内容布局ID
     *
     * @return 布局Id
     */
    protected abstract int setContentView();

    /**
     * 初始化当前页面的控件view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    protected void initTitleView(String leftTextView, String centerTextView, String rightTextView, int leftImageView, int rightImageView) {

        if (null != leftTextView) {
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText(leftTextView);
        }
        if (null != centerTextView) {
            tv_center.setVisibility(View.VISIBLE);
            tv_center.setText(centerTextView);
        }
        if (null != rightTextView) {
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText(rightTextView);
        }

        if (ZERO != leftImageView) {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(leftImageView);
        }

        if (ZERO != rightImageView) {
            iv_right.setVisibility(View.VISIBLE);
            iv_right.setImageResource(rightImageView);
        }
    }

}
