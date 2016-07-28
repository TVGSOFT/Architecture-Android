package com.tvgsoft.core.viewmodel;

import android.databinding.Bindable;

import com.tvgsoft.core.BR;
import com.tvgsoft.core.model.entities.Category;
import com.tvgsoft.core.model.entities.Video;
import com.tvgsoft.core.model.entities.VideoDetail;
import com.tvgsoft.core.model.responses.ResponseCategory;
import com.tvgsoft.core.model.services.IGoogleApiService;
import com.tvgsoft.core.view.Constants;
import com.tvgsoft.core.view.INavigator;

import java.io.InvalidObjectException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TVG on 7/19/16.
 */
public final class MainViewModel extends BaseViewModel {

    //region Properties

    private IGoogleApiService mGoogleApiService;

    private Category mCategory;

    private List<Video> mVideos;

    //endregion

    //region Getter and Setter

    @Bindable
    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;

        if (mCategory != null) {
            setVideos(mCategory.getVideos());
        } else {
            setVideos(null);
        }
    }

    @Bindable
    public List<Video> getVideos() {
        return mVideos;
    }

    public void setVideos(List<Video> videos) {
        mVideos = videos;

        notifyPropertyChanged(BR.videos);
    }

    //endregion

    //region Constructors

    /**
     *
     * @param navigator Navigate controller.
     * @param service GoogleApiService.
     */
    public MainViewModel(INavigator navigator, IGoogleApiService service) {
        super(navigator);

        mGoogleApiService = service;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        getNavigator().showBusyIndicator("Loading");

        loadCategory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mCategory = null;
    }

    //endregion

    //region Public methods

    /**
     * Show video detail.
     * @param video Video want to show.
     */
    public void showDetail(Video video) {
        try {
            VideoDetail videoDetail = new VideoDetail.Builder()
                                                     .dash(mCategory.getDash())
                                                     .hls(mCategory.getHls())
                                                     .mp4(mCategory.getMp4())
                                                     .images(mCategory.getImages())
                                                     .video(video)
                                                     .build();

            getEventBus().postSticky(videoDetail);
        } catch (InvalidObjectException e) {
            getNavigator().showMessage("Error", e.getMessage(), "OK", null);

            return;
        }

        getNavigator().navigateTo(Constants.DETAIL_PAGE);
    }

    /**
     * Play video.
     * @param video Video want to play.
     */
    public void playVideo(Video video) {
        try {
            VideoDetail videoDetail = new VideoDetail.Builder()
                                                     .dash(mCategory.getDash())
                                                     .hls(mCategory.getHls())
                                                     .mp4(mCategory.getMp4())
                                                     .images(mCategory.getImages())
                                                     .video(video)
                                                     .build();

            getEventBus().postSticky(videoDetail);
        } catch (InvalidObjectException e) {
            getNavigator().showMessage("Error", e.getMessage(), "OK", null);

            return;
        }

        getNavigator().navigateTo(Constants.PLAYER_PAGE);
    }

    //endregion

    //region Private methods

    private void loadCategory() {
        mGoogleApiService.getCategory()
                         .enqueue(new Callback<ResponseCategory>() {

                             @Override
                             public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {
                                 ResponseCategory responseCategory = response.body();
                                 if (responseCategory != null && !responseCategory.getCategories().isEmpty()) {
                                     Category category = response.body()
                                                                 .getCategories()
                                                                 .get(0);

                                     setCategory(category);
                                 }

                                 getNavigator().hideBusyIndicator();
                             }

                             @Override
                             public void onFailure(Call<ResponseCategory> call, Throwable t) {
                                 getNavigator().hideBusyIndicator();
                                 getNavigator().showMessage("Failure", t.getMessage(), "OK", null);
                             }

                         });
    }

    //endregion

}
