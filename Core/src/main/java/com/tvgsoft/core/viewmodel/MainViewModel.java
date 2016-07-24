package com.tvgsoft.core.viewmodel;

import com.tvgsoft.core.model.entities.Category;
import com.tvgsoft.core.model.entities.Video;
import com.tvgsoft.core.model.entities.VideoDetail;
import com.tvgsoft.core.model.responses.ResponseCategory;
import com.tvgsoft.core.model.services.IGoogleApiService;
import com.tvgsoft.core.view.Constants;
import com.tvgsoft.core.view.Navigator;
import java.io.InvalidObjectException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by giaptran on 7/19/16.
 */

public final class MainViewModel extends BaseViewModel {

    //region Properties

    private IGoogleApiService mGoogleApiService;

    private Category mCategory;

    //endregion

    //region Constructors

    /**
     * @param navigator
     */
    protected MainViewModel(Navigator navigator, IGoogleApiService service) {
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

    public void showDetail(Video video) {
        getNavigator().navigateTo(Constants.DETAIL_PAGE);

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
        }
    }

    public void playVideo(Video video) {
        getNavigator().navigateTo(Constants.PLAYER_PAGE);

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
        }
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
                                     mCategory = response.body()
                                                         .getCategories()
                                                         .get(0);

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
