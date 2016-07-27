package com.tvgsoft.arc;

import com.tvgsoft.arc.activities.DetailActivity;
import com.tvgsoft.arc.activities.MainActivity;
import com.tvgsoft.arc.activities.PlayerActivity;
import com.tvgsoft.core.di.AppModule;
import com.tvgsoft.core.di.CloudModule;
import com.tvgsoft.core.di.ViewModelModule;
import com.tvgsoft.core.view.BaseApplication;
import com.tvgsoft.core.view.Constants;
import com.tvgsoft.core.view.INavigator;

/**
 * Created by TVG on 7/19/16.
 */
public class App extends BaseApplication {

    //region Properties

    private static AppComponent sAppComponent;

    //endregion

    //region Getter and Setter

    public synchronized static AppComponent sharedComponent() {
        return sAppComponent;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);
        INavigator navigator = appModule.getNavigator();
        navigator.configure(Constants.MAIN_PAGE, MainActivity.class);
        navigator.configure(Constants.DETAIL_PAGE, DetailActivity.class);
        navigator.configure(Constants.PLAYER_PAGE, PlayerActivity.class);

        sAppComponent = DaggerAppComponent.builder()
                                          .appModule(appModule)
                                          .cloudModule(new CloudModule())
                                          .viewModelModule(new ViewModelModule())
                                          .build();
    }

    //endregion

}
