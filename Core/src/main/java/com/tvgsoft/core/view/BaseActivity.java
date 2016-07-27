package com.tvgsoft.core.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.tvgsoft.core.viewmodel.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by TVG on 7/19/16.
 */

public abstract class BaseActivity<B extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    //region Properties

    protected B mViewDataBinding;

    @Inject
    protected V mViewModel;

    //endregion

    //region Lifecycle

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mViewModel != null) {
            mViewModel.onCreate();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mViewModel != null) {
            mViewModel.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mViewModel != null) {
            mViewModel.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mViewModel != null) {
            mViewModel.onDestroy();
        }
    }

    //endregion

    //region Protected Methods

    protected void setBindingContentView(int layoutResId, int variableId) {
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutResId);
        mViewDataBinding.setVariable(variableId, mViewModel);
    }

    //endregion

}
