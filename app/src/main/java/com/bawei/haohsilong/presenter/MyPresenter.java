package com.bawei.haohsilong.presenter;

import android.util.Log;

import com.bawei.haohsilong.Icontarct.Icontarct;
import com.bawei.haohsilong.MainActivity;
import com.bawei.haohsilong.base.BasePresenter;
import com.bawei.haohsilong.bean.Shop;
import com.bawei.haohsilong.model.MyModel;
import com.google.gson.Gson;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:15
 *@Description:${presenter层}
 **/public class MyPresenter extends BasePresenter implements Icontarct.Presen {
    //实例化model
    MyModel model;
    public MyPresenter() {
        model=new MyModel();
    }

    @Override
    public void toRequest(String url) {
        model.Infor(url, new Icontarct.CallBack() {
            @Override
            public void success(String json) {
                //解析
                Gson gson=new Gson();
                Shop shop = gson.fromJson(json, Shop.class);
                //⑦　使用debug级别的log输出请求的数据。
                Log.i("sj","sjj"+json);
                MainActivity activity= (MainActivity) v;
                activity.success(shop);
            }

            @Override
            public void error(String er) {

            }
        });

    }
}
