package com.tvgsoft.core.viewmodel;

import android.databinding.Bindable;

import com.tvgsoft.core.BR;
import com.tvgsoft.core.model.entities.VideoDetail;
import com.tvgsoft.core.view.Constants;
import com.tvgsoft.core.view.INavigator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by TVG on 7/19/16.
 */

public final class DetailViewModel extends BaseViewModel {

    //region Properties

    private VideoDetail mVideoDetail;

    //endregion

    //region Getter and Setter

    @Bindable
    public VideoDetail getVideoDetail() {
        return mVideoDetail;
    }

    public void setVideoDetail(VideoDetail videoDetail) {
        mVideoDetail = videoDetail;

        notifyPropertyChanged(BR.videoDetail);
    }

    //endregion

    //region Constructors

    /**
     * @param navigator Navigate controller.
     */
    public DetailViewModel(INavigator navigator) {
        super(navigator);
    }

    //endregion

    //region Lifecycle


    @Override
    public void onCreate() {
        super.onCreate();

        getEventBus().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        setVideoDetail(null);
    }

    //endregion

    //region Public Methods

    /**
     * Play video.
     */
    public void playVideo() {
        if (getVideoDetail() != null) {
            getNavigator().navigateTo(Constants.PLAYER_PAGE);

            getEventBus().postSticky(getVideoDetail());
        }
    }

    /**
     *
     * @param data Receive video detail.
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(VideoDetail data) {
        setVideoDetail(data);

        getEventBus().unregister(this);
    }

    //endregion

}
