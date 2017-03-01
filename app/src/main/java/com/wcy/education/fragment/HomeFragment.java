package com.wcy.education.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wcy.education.R;
import com.wcy.education.adapter.DividerItemDecoration;
import com.wcy.education.adapter.HomeRecyclerAdapter;
import com.wcy.education.base.BaseFragment;
import com.wcy.education.entity.ImageInfo;
import com.wcy.education.view.SlideShowView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class HomeFragment extends BaseFragment {

    private SlideShowView mySlideShowView;
    private List<ImageInfo> picList;
    private RecyclerView homeRecyclerView;
    private HomeRecyclerAdapter adapter;
    private List<String> recyclerViewList;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        homeRecyclerView = (RecyclerView) view.findViewById(R.id.homeRecyclerView);
        mySlideShowView = (SlideShowView) view.findViewById(R.id.mySlideShowView);
        recyclerViewList = new ArrayList<>();
        picList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        ImageInfo imageInfo = new ImageInfo();
        for (int i = 0; i < 3; i++) {
            picList.add(i, imageInfo);
        }

        List<String> ls = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            ls.add(picList.get(i).getTopImage());
//        }
        ls.add("http://114.55.249.252/education/images/top/banner002.jpg");
        ls.add("http://114.55.249.252/education/images/top/jiaoshizigezheng.jpg");

        mySlideShowView.setImagePath(ls);
        mySlideShowView.startPlay();
        for (int i = 0; i < 50; i++) {
            recyclerViewList.add("item:" + i);
        }
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        homeRecyclerView.setHasFixedSize(true);

        homeRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        adapter = new HomeRecyclerAdapter(getActivity(), recyclerViewList);


        homeRecyclerView.setAdapter(adapter);
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    protected void initData(View view) {

    }
}
