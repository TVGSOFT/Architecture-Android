package com.tvgsoft.core.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import com.tvgsoft.core.R;

/**
 * Created by TVG on 7/24/16.
 */
public class BusyIndicator extends Dialog {

    //region Properties

    private TextView mTextViewTitle;

    //endregion

    //region Constructors

    public BusyIndicator(Context context) {
        super(context);

        initialize();
    }

    protected BusyIndicator(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

        initialize();
    }

    public BusyIndicator(Context context, int themeResId) {
        super(context, themeResId);

        initialize();
    }

    //endregion

    //region Override methods

    @Override
    public void setTitle(CharSequence title) {
        mTextViewTitle.setText(title);
    }

    //endregion

    //region Private methods

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.busy_indicator);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(false);

        mTextViewTitle = (TextView) findViewById(R.id.tv_title);
    }

    //endregion

}
