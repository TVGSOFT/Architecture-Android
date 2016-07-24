package com.tvgsoft.core.model.responses;

/**
 * Created by TVG on 7/24/16.
 */
public abstract class Response {

    //region Properties

    private String mMessage;

    private int mStatusCode;

    //endregion

    //region Getter and Setter

    public String getMessage() {
        return mMessage;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    //endregion

}
