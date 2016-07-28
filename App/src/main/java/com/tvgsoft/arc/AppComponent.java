package com.tvgsoft.arc;

import com.tvgsoft.arc.activities.DetailActivity;
import com.tvgsoft.arc.activities.MainActivity;
import com.tvgsoft.arc.activities.PlayerActivity;
import com.tvgsoft.core.di.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TVG on 7/27/16.
 */

@Singleton
@Component(modules = { ViewModelModule.class })
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(DetailActivity activity);

    void inject(PlayerActivity activity);

}
