package com.tvgsoft.core.di;

import com.tvgsoft.core.view.BaseApplication;
import com.tvgsoft.core.view.INavigator;
import com.tvgsoft.core.view.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TVG on 7/19/16.
 */

@Module
public class AppModule {

    //region Properties

    private INavigator mNavigator;

    //endregion

    //region Getter and Setter

    public INavigator getNavigator() {
        return mNavigator;
    }

    //endregion

    //region Constructors

    public AppModule(BaseApplication application) {
        mNavigator = new Navigator(application);
    }

    //endregion

    //region Provide methods

    @Provides
    @Singleton
    BaseApplication providesApplication() {
        return mNavigator.getApplication();
    }

    @Provides
    @Singleton
    INavigator providesNavigator() {
        return mNavigator;
    }

    //endregion

}
