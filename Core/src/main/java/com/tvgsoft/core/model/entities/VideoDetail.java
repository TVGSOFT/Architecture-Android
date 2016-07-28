package com.tvgsoft.core.model.entities;

import java.io.InvalidObjectException;

/**
 * Created by TVG on 7/19/16.
 */

public class VideoDetail extends Entity {

    //region Properties

    private String mHls;

    private String mDash;

    private String mMp4;

    private String mImages;

    private Video mVideo;

    //endregion

    //region Getter and Setter

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

    public Video getVideo() {
        return mVideo;
    }

    public void setVideo(Video video) {
        mVideo = video;
    }

    //endregion

    //region Constructors

    private VideoDetail() {

    }

    //endregion

    //region Builder

    public static class Builder implements IBuilder<VideoDetail> {

        //region Properties

        private String mHls;

        private String mDash;

        private String mMp4;

        private String mImages;

        private Video mVideo;

        //endregion

        //region Setter

        public Builder hls(String hls) {
            mHls = hls;
            return this;
        }

        public Builder dash(String dash) {
            mDash = dash;
            return this;
        }

        public Builder mp4(String mp4) {
            mMp4 = mp4;
            return this;
        }

        public Builder images(String images) {
            mImages = images;
            return this;
        }

        public Builder video(Video video) throws InvalidObjectException {
            if (video == null) {
                throw new InvalidObjectException("Video can't empty.");
            }
            mVideo = video;
            return this;
        }

        //endregion

        //region IBuilder implement

        @Override
        public VideoDetail build() {
            VideoDetail videoDetail = new VideoDetail();
            videoDetail.setHls(mHls);
            videoDetail.setDash(mDash);
            videoDetail.setMp4(mMp4);
            videoDetail.setImages(mImages);
            videoDetail.setVideo(mVideo);
            return videoDetail;
        }

        //endregion

    }

    //endregion

}
