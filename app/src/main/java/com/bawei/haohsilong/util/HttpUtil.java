package com.bawei.haohsilong.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:16
 *@Description:${工具类}
 **/public class HttpUtil {
    //①　使用单例模式封装网络工具类。
    //单例模式
    public static HttpUtil httpUtil=new HttpUtil();
    //私有构造
    private HttpUtil() {
    }
    public static HttpUtil getInstance(){
        return httpUtil;
    }
    //网络请求
    //②　封装网络判断的方法，可以判断网络状态（有网、无网、wifi、移动网络）。
    public boolean doNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
    //请求数据
    public String doData(String url){
        //③　封装get请求方法（处理异常、判断响应状态码、关闭流）。
        try {
            URL url1=new URL(url);
            HttpURLConnection conn= (HttpURLConnection) url1.openConnection();
            //get请求
            conn.setRequestMethod("GET");
            //响应时间
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            //获取状态码
            int code = conn.getResponseCode();
            if (code==200){
                BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String temp="";
                StringBuilder builder=new StringBuilder();
                while ((temp=reader.readLine())!=null){
                    builder.append(temp);
                }
                return builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
