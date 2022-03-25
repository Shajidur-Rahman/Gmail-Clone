package com.shajidurrahman;

import android.app.Application;
import android.content.Context;

public class MyApplicatiion extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplicatiion.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplicatiion.context;
    }
}