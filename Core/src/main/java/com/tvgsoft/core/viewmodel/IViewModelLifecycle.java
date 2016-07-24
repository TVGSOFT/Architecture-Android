package com.tvgsoft.core.viewmodel;

/**
 * Created by TVG on 7/19/16.
 */

public interface IViewModelLifecycle {

    void onCreate();

    void onStart();

    void onStop();

    void onDestroy();

}
