package com.tvgsoft.core.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TVG on 7/24/16.
 */
public class Category extends Entity {

    //region Properties

    @SerializedName("name")
    private String mName;

    @SerializedName("hls")
    private String mHls;

    @SerializedName("dash")
    private String mDash;

    @SerializedName("mp4")
    private String mMp4;

    @SerializedName("images")
    private String mImages;

    @SerializedName("videos")
    private List<Video> mVideos;

    //endregion

    //region Getter and Setter

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getHls() {
        return mHls;
    }

    public void setHls(String hls) {
        mHls = hls;
    }

    public String getDash() {
        return mDash;
    }

    public void setDash(String dash) {
        mDash = dash;
    }

    public String getMp4() {
        return mMp4;
    }

    public void setMp4(String mp4) {
        mMp4 = mp4;
    }

    public String getImages() {
        return mImages;
    }

    public void setImages(String images) {
        mImages = images;
    }

    public List<Video> getVideos() {
        return mVideos;
    }

    public void setVideos(List<Video> videos) {
        mVideos = videos;
    }

    //endregion

}
