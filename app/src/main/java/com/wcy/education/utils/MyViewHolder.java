package com.wcy.education.utils;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class MyViewHolder {
    private final SparseArray<View> mView;
    private View converView;

    private MyViewHolder(ViewGroup parent, LayoutInflater inflater, int layoutId) {

        this.mView = new SparseArray<>();
        converView = inflater.inflate(layoutId, parent, false);
        converView.setTag(this);

    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param converView
     * @param parent
     * @param layoutId
     */
    public static MyViewHolder getMyHolderView(View converView, ViewGroup parent, int layoutId, LayoutInflater inflater) {

        if (converView == null) {
            return new MyViewHolder(parent, inflater, layoutId);
        }
        return (MyViewHolder) converView.getTag();
    }


    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = converView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }


    public View getConverView() {
        return converView;
    }

    /**
     * 根据id得到TextView
     *
     * @param viewId
     * @return
     */
    public TextView getTextView(int viewId) {
        return getView(viewId);
    }

    /**
     * 根据id得到ImageView
     *
     * @param viewId
     * @return
     */
    public ImageView getImageView(int viewId) {
        return getView(viewId);
    }

    /**
     * 根据id得到Button
     *
     * @param viewId
     * @return
     */
    public Button getButton(int viewId) {
        return getView(viewId);
    }


    /**
     * 根据id得到RadioButton
     *
     * @param viewId
     * @return
     */
    public RadioButton getRadioButton(int viewId) {
        return getView(viewId);
    }


    /**
     * 根据id得到CheckBox
     *
     * @param viewId
     * @return
     */
    public CheckBox getCheckBox(int viewId) {
        return getView(viewId);
    }

    /**
     * 根据id得到ImageButton
     *
     * @param viewId
     * @return
     */
    public ImageButton getImageButton(int viewId) {
        return getView(viewId);
    }

    /**
     * 根据id得到editText
     *
     * @param viewId
     * @return
     */
    public EditText getEditText(int viewId) {
        return getView(viewId);
    }

    /**
     * 根据id得到RelativeLayout
     *
     * @param viewId
     * @return
     */
    public RelativeLayout getRelativeLayout(int viewId) {
        return getView(viewId);
    }


}
