package com.wcy.education.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * 抽像BaseRecyclerView
 * Created by Administrator on 2017/2/28 0028.
 *
 * @param <VH>
 * @param <T>
 */


public abstract class MyBaseRecyclerView<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH> {

    protected Context context;
    protected List<T> myList;


    public MyBaseRecyclerView(Context mContext, List<T> mList) {
        this.context = mContext;
        this.myList = mList;
    }

    public T getItem(int position) {
        if (position < myList.size()) {
            return myList.get(position);
        } else return null;
    }

    public int getItemCount() {
        return myList.size();
    }

}
