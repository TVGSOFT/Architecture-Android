package com.tvgsoft.arc.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tvgsoft.arc.App;
import com.tvgsoft.arc.BR;
import com.tvgsoft.arc.R;
import com.tvgsoft.arc.adapters.VideoListAdapter;
import com.tvgsoft.arc.databinding.ActivityMainBinding;
import com.tvgsoft.core.view.BaseActivity;
import com.tvgsoft.core.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    //region Properties

    private VideoListAdapter mVideoListAdapter;

    //endregion

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent()
                .inject(this);

        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_main, BR.viewModel);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mVideoListAdapter = new VideoListAdapter();
        mVideoListAdapter.setViewModel(mViewModel);
        recyclerView.setAdapter(mVideoListAdapter);
    }

    //endregion

}
