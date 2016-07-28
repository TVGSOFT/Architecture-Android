package com.tvgsoft.core.view;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by TVG on 7/18/16.
 */
public class Constants {

    //region Constructors

    private Constants() {

    }

    //endregion

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            ROOT, MAIN_PAGE, DETAIL_PAGE, PLAYER_PAGE
    })
    public @interface PageKey {}

    public static final int ROOT = -1;
    public static final int MAIN_PAGE = 0;
    public static final int DETAIL_PAGE = 1;
    public static final int PLAYER_PAGE = 2;

}
