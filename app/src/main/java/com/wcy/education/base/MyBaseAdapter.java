package com.wcy.education.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.wcy.education.utils.MyViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28 0028.
 *
 * @param <T>
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected List<T> myList;
    protected Context context;
    protected LayoutInflater inflater;
    protected int layoutId;

    public MyBaseAdapter(List<T> baseList, Context context, LayoutInflater inflater, int layoutId) {
        this.myList = baseList;
        this.context = context;
        this.inflater = inflater;
        this.layoutId = layoutId;
        this.inflater = LayoutInflater.from(context);
    }


    public void addItem(T item) {
        myList.add(item);
        notifyDataSetChanged();
    }

    @Override

    public int getCount() {
        if (myList != null) {
            return myList.size();
        }
        return 0;
    }

    @Override
    public T getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder = MyViewHolder.getMyHolderView(convertView, parent, layoutId, inflater);
        convert(myViewHolder, myList.get(position), position);
        return myViewHolder.getConverView();
    }

    public abstract void convert(MyViewHolder myViewHolder, T t, int position);
}
