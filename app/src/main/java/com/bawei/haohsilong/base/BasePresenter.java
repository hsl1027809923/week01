package com.bawei.haohsilong.base;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:03
 *@Description:${presenter基类}
 **/public class BasePresenter<V extends BaseActivity> {
    public V v;
    //绑定方法
    public void acctch(V v){
        this.v=v;
    }
    //解绑方法
    public void Uacctch(){
        if (v!=null){
            v=null;
        }
    }
}
