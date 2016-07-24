package com.tvgsoft.core.viewmodel;

import android.databinding.BaseObservable;
import com.tvgsoft.core.view.Navigator;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by TVG on 7/19/16.
 */
public abstract class BaseViewModel extends BaseObservable implements IViewModelLifecycle {

    //region Properties

    private Navigator mNavigator;

    private EventBus mEventBus;

    //endregion

    //region Setter and Getter

    /**
     *
     * @return
     */
    protected Navigator getNavigator() {
        return mNavigator;
    }

    protected EventBus getEventBus() {
        if (mEventBus == null) {
            mEventBus = EventBus.getDefault();
        }
        return mEventBus;
    }

    //endregion

    //region Constructors

    /**
     *
     * @param navigator
     */
    protected BaseViewModel(Navigator navigator) {
        mNavigator = navigator;
    }

    //endregion

    //region IViewModelLifecycle implements

    @Override
    public void onCreate()  {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop()  {

    }

    @Override
    public void onDestroy() {
        mEventBus = null;
    }

    //endregion

}
