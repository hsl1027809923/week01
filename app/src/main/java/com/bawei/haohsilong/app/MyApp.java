package com.bawei.haohsilong.app;

import android.app.Application;
import android.content.Context;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:07
 *@Description:${context上下文}
 **/public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
