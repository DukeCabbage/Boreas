package com.cabbage.boreas;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
//        Stetho.initializeWithDefaults(this);
        Timber.plant(new Timber.DebugTree() {
            //add line number to the tag
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ':' + element.getLineNumber();
            }
        });
    }

    public static synchronized MyApplication getInstance(Context context) {
        return (MyApplication) context.getApplicationContext();
    }
}
