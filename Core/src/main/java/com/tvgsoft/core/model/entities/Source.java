package com.tvgsoft.core.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TVG on 7/24/16.
 */
public class Source extends Entity {

    //region Properties

    @SerializedName("type")
    private String mType;

    @SerializedName("mime")
    private String mMime;

    @SerializedName("url")
    private String mUrl;

    //endregion

    //region Getter and Setter

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getMime() {
        return mMime;
    }

    public void setMime(String mime) {
        mMime = mime;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    //endregion

}
