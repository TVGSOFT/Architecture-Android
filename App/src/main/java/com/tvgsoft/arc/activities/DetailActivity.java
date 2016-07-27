package com.tvgsoft.arc.activities;

import android.os.Bundle;
import com.tvgsoft.arc.App;
import com.tvgsoft.arc.BR;
import com.tvgsoft.arc.R;
import com.tvgsoft.arc.databinding.ActivityDetailBinding;
import com.tvgsoft.core.view.BaseActivity;
import com.tvgsoft.core.viewmodel.DetailViewModel;

/**
 * Created by TVG on 7/19/16.
 */

public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> {

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent()
           .inject(this);

        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_detail, BR.viewModel);
    }

    //endregion

}
