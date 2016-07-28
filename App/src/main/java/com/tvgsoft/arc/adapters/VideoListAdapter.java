package com.tvgsoft.arc.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tvgsoft.arc.BR;
import com.tvgsoft.arc.R;
import com.tvgsoft.core.model.entities.Video;
import com.tvgsoft.core.view.BaseRecyclerViewAdapter;
import com.tvgsoft.core.view.ViewHolder;
import com.tvgsoft.core.viewmodel.MainViewModel;

import java.util.List;

/**
 * Created by TVG on 7/28/16.
 */
public class VideoListAdapter extends BaseRecyclerViewAdapter<MainViewModel, List<Video>> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_video, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = ((ViewHolder) holder).getViewDataBinding();
        viewDataBinding.setVariable(BR.viewModel, mViewModel);
        viewDataBinding.setVariable(BR.video, mData.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

}
