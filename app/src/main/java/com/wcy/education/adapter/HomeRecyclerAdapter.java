package com.wcy.education.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wcy.education.R;
import com.wcy.education.base.MyBaseRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class HomeRecyclerAdapter extends MyBaseRecyclerView<HomeRecyclerAdapter.MyViewHolder,String> {

    public HomeRecyclerAdapter(Context mContext, List<String> mList) {
        super(mContext, mList);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                  MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
          holder.idNum.setText(myList.get(position));
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idNum;
        View itemView;

        public MyViewHolder(View view) {
            super(view);
            itemView = view;
            idNum = (TextView) view.findViewById(R.id.textView);
        }
    }
}
