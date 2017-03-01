package com.wcy.education;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import com.wcy.education.base.BaseActivity;
import com.wcy.education.fragment.FlyFragment;
import com.wcy.education.fragment.HomeFragment;
import com.wcy.education.fragment.HunterFragment;
import com.wcy.education.fragment.MineFragment;

public class MainActivity extends BaseActivity {
    //声明FragmentTabHost
    private FragmentTabHost tabHost;
    //四个Fragment容器
    private View view1, view2, view3, view4;
    //底部内容
    private String toArray[] = {"首页", "放飞梦想", "赏金猎人", "个人中心"};
    //layoutInflater 布局填充
    private LayoutInflater inflater;
    //Fragment布局数组
    private Class<?>[] fragments = {HomeFragment.class, FlyFragment.class, HunterFragment.class, MineFragment.class};


    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        inflater = LayoutInflater.from(this);
        tabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        tabHost.getTabWidget().setDividerDrawable(null);
        view1 = inflater.inflate(R.layout.tab_shouye, null);
        view2 = inflater.inflate(R.layout.tab_fly, null);
        view3 = inflater.inflate(R.layout.tab_hunter, null);
        view4 = inflater.inflate(R.layout.tab_mine, null);

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec(toArray[0]).setIndicator(view1);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec(toArray[1]).setIndicator(view2);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec(toArray[2]).setIndicator(view3);
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec(toArray[3]).setIndicator(view4);

        tabHost.addTab(tabSpec1, fragments[0], null);
        tabHost.addTab(tabSpec2, fragments[1], null);
        tabHost.addTab(tabSpec3, fragments[2], null);
        tabHost.addTab(tabSpec4, fragments[3], null);


    }

    @Override
    protected void initData() {

    }
}
