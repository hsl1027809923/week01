package com.bawei.haohsilong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:01
 *@Description:${activity基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(Layout());
        p=PLayout();
        //绑定
        if (p!=null){
            //绑定方法
            p.acctch(this);
        }
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int Layout();
    protected abstract P PLayout();
    //解绑方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            //解绑方法
            p.Uacctch();
            p=null;
        }
    }
}
