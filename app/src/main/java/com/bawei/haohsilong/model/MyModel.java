package com.bawei.haohsilong.model;

import com.bawei.haohsilong.Icontarct.Icontarct;
import com.bawei.haohsilong.jsonTask.JsonTask;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:16
 *@Description:${model层}
 **/public class MyModel implements Icontarct.Mode {

    //调用
    @Override
    public void Infor(String url, final Icontarct.CallBack callBack) {
        new JsonTask(new JsonTask.TaskBack() {
            @Override
            public void success(String json) {
                callBack.success(json);
            }

            @Override
            public void error(String er) {
                callBack.error(er);
            }
        }).execute(url);
    }

    @Override
    public void Post(String url, Icontarct.CallBack callBack) {

    }

}
