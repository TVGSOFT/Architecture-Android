package com.tvgsoft.core.di;

import com.tvgsoft.core.model.services.IGoogleApiService;
import com.tvgsoft.core.view.INavigator;
import com.tvgsoft.core.viewmodel.DetailViewModel;
import com.tvgsoft.core.viewmodel.MainViewModel;
import com.tvgsoft.core.viewmodel.PlayerViewModel;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by TVG on 7/27/16.
 */

@Module(includes = { CloudModule.class })
public class ViewModelModule {

    //region Provide methods

    @Provides
    @Singleton
    public MainViewModel providesMainViewModel(INavigator navigator, IGoogleApiService apiService) {
        return new MainViewModel(navigator, apiService);
    }

    @Provides
    @Singleton
    public DetailViewModel providesDetailViewModel(INavigator navigator) {
        return new DetailViewModel(navigator);
    }

    @Provides
    @Singleton
    public PlayerViewModel providesPlayerViewModel(INavigator navigator) {
        return new PlayerViewModel(navigator);
    }

    //endregion

}
