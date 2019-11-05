package com.bawei.haohsilong.jsonTask;

import android.os.AsyncTask;

import com.bawei.haohsilong.util.HttpUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:23
 *@Description:${Task类}
 **/public class JsonTask extends AsyncTask<String,Void,String> {
    //声明接口
    TaskBack taskBack;

    public JsonTask(TaskBack taskBack) {
        this.taskBack = taskBack;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s = HttpUtil.getInstance().doData(strings[0]);
        return s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //判断
        if (s.isEmpty()){
            taskBack.error("响应失败");
        }else {
            taskBack.success(s);
        }

    }
    //创建接口回调
    public interface TaskBack{
        //成功和失败
        void success(String json);
        void error(String er);
    }
}
