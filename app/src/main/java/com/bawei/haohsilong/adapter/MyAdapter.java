package com.bawei.haohsilong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.haohsilong.R;
import com.bawei.haohsilong.bean.Shop;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:45
 *@Description:${适配器}
 **/public class MyAdapter extends BaseAdapter {
    //集合上下文
    List<Shop.GriddataBean> list;
    Context context;

    public MyAdapter(List<Shop.GriddataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.item_layout,null);
            viewHolder.texta=convertView.findViewById(R.id.text_itema);
            viewHolder.textb=convertView.findViewById(R.id.text_itemb);
            viewHolder.imageView=convertView.findViewById(R.id.img_item);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.texta.setText(list.get(position).getTitle());
        viewHolder.textb.setText(list.get(position).getPrice());
        Glide.with(context).load(list.get(position).getImageurl()).into(viewHolder.imageView);
        return convertView;
    }
    //自定义
    public class ViewHolder{
        ImageView imageView;
        TextView texta,textb;
    }


}
