package com.tvgsoft.arc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tvgsoft.arc.R;
import com.tvgsoft.core.view.BaseApplication;
import com.tvgsoft.core.view.Navigator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigator navigator = new Navigator((BaseApplication) getApplication());
        navigator.showBusyIndicator("Loading");
    }
}
