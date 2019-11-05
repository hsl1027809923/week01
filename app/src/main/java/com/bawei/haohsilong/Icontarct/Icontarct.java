package com.bawei.haohsilong.Icontarct;

import com.bawei.haohsilong.bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:27
 *@Description:${DESCRIPTION}
 **/public interface Icontarct {
    //⑤　封装契约接口，统一管理MVP接口。
    //V层
    interface View{
        void success(Shop shop);
    }
    //M层
    interface Mode{
        void Infor(String url,CallBack callBack);
        void Post(String url,CallBack callBack);
    }
    //p层
    interface Presen{
        void toRequest(String url);
    }
    //返回
    interface CallBack{
        void success(String json);
        void error(String er);
    }
}
