package com.tvgsoft.core.view;

/**
 * Created by TVG on 7/18/16.
 */
public interface INavigator {

    /**
     * Get current key of page.
     * @return
     */
    @Constants.PageKey int getCurrentKey();

    /**
     * Go back page.
     */
    void goBack();

    /**
     * Navigate to page.
     * @param pageKey
     */
    void navigateTo(@Constants.PageKey int pageKey);

    /**
     * Show dialog with message.
     * @param title
     * @param message
     * @param buttonText
     * @param callback
     */
    void showMessage(
            String title,
            String message,
            String buttonText,
            ICallback callback);

    /**
     * Show dialog with message.
     * @param title
     * @param message
     * @param buttonConfirmText
     * @param buttonCancelText
     * @param callback
     */
    void showMessage(
            String title,
            String message,
            String buttonConfirmText,
            String buttonCancelText,
            ICallback callback);

    /**
     * Show busy indicator.
     * @param title
     */
    void showBusyIndicator(String title);

    /**
     * Hide busy indicator.
     */
    void hideBusyIndicator();

    /**
     * Check busy indicator is showing
     * @return
     */
    boolean isBusyIndicatorShowing();

}
