package com.bawei.haohsilong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.haohsilong.Icontarct.Icontarct;
import com.bawei.haohsilong.adapter.MyAdapter;
import com.bawei.haohsilong.app.MyApp;
import com.bawei.haohsilong.appis.API;
import com.bawei.haohsilong.base.BaseActivity;
import com.bawei.haohsilong.base.BasePresenter;
import com.bawei.haohsilong.bean.Shop;
import com.bawei.haohsilong.model.MyModel;
import com.bawei.haohsilong.presenter.MyPresenter;
import com.bawei.haohsilong.util.HttpUtil;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:01
 *@Description:${主页面}
 **/
public class MainActivity extends BaseActivity implements Icontarct.View {
    //④　项目采用MVP架构，分包明确。
    XBanner xBanner;
    GridView gridView;
    //设置数据
    @Override
    protected void initData() {
        //加载接口 传到p层
        API api=new API();
        MyPresenter presenter= (MyPresenter) p;
        presenter.toRequest(api.toUrl());
    }
    //初始化控件
    @Override
    protected void initView() {
        xBanner=findViewById(R.id.xbanner_a);

        gridView=findViewById(R.id.grid_a);
    }
    //加载布局
    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter PLayout() {
        return new MyPresenter();
    }

    @Override
    public void success(final Shop shop) {
        //⑥　封装网络响应接口回调，在回调中封装响应成功和响应失败的方法。
        boolean b = HttpUtil.getInstance().doNet(MyApp.context);
        if (b){
            //有网
            //xbanner轮播
            xBanner.setBannerData(shop.getBannerdata());
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(MyApp.context).load(shop.getBannerdata().get(position).getImageurl()).into((ImageView) view);
                }
            });


            //gridview网格
            //适配器
            MyAdapter adapter=new MyAdapter(shop.getGriddata(),this);
            gridView.setAdapter(adapter);
        }else {
            //没网
            Toast.makeText(this, "请检查网络", Toast.LENGTH_SHORT).show();
        }

    }
}
