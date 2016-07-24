package com.tvgsoft.core.model.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by TVG on 7/19/16.
 */

public class Video extends Entity {

    //region Properties

    @SerializedName("subtitle")
    private String mSubtitle;

    @SerializedName("sources")
    private List<Source> mSources;

    @SerializedName("thumb")
    private String mThumb;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("studio")
    private String mStudio;

    @SerializedName("duration")
    private long mDuration;

    //endregion

    //region Getter and Setter

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
    }

    public List<Source> getSources() {
        return mSources;
    }

    public void setSources(List<Source> sources) {
        mSources = sources;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getStudio() {
        return mStudio;
    }

    public void setStudio(String studio) {
        mStudio = studio;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    //endregion

}
