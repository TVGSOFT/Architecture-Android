package com.tvgsoft.core.view;

import android.support.v7.widget.RecyclerView;
import com.tvgsoft.core.viewmodel.BaseViewModel;

/**
 * Created by TVG on 7/27/16.
 */
public abstract class BaseRecyclerViewAdapter<V extends BaseViewModel, T> extends RecyclerView.Adapter {

    //region Properties

    protected V mViewModel;

    protected T mData;

    //endregion

    //region Getter and Setter

    public void setViewModel(V viewModel) {
        mViewModel = viewModel;
    }

    public void setData(T data) {
        mData = data;

        notifyDataSetChanged();
    }

    //endregion

}
