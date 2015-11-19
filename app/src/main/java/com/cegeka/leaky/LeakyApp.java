package com.cegeka.leaky;

import android.app.Application;

public class LeakyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BeanProvider.init(this);
    }
}
