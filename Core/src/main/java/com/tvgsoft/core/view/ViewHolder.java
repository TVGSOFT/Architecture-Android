package com.tvgsoft.core.view;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by TVG on 7/28/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;

    public ViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());

        mViewDataBinding = viewDataBinding;
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }

}
