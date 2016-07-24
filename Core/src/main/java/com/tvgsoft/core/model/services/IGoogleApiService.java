package com.tvgsoft.core.model.services;

import com.tvgsoft.core.model.responses.ResponseCategory;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TVG on 7/19/16.
 */

public interface IGoogleApiService {

    @GET("/gtv-videos-bucket/CastVideos/f.json")
    Call<ResponseCategory> getCategory();

}
