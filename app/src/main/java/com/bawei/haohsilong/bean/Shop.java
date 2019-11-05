package com.bawei.haohsilong.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-11-05
 *@Time:9:27
 *@Description:${DESCRIPTION}
 **/public class Shop {
    private String code;
    private List<BannerdataBean> bannerdata;
    private List<GriddataBean> griddata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BannerdataBean> getBannerdata() {
        return bannerdata;
    }

    public void setBannerdata(List<BannerdataBean> bannerdata) {
        this.bannerdata = bannerdata;
    }

    public List<GriddataBean> getGriddata() {
        return griddata;
    }

    public void setGriddata(List<GriddataBean> griddata) {
        this.griddata = griddata;
    }

    public static class BannerdataBean extends SimpleBannerInfo {
        private String imageurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        @Override
        public Object getXBannerUrl() {
            return null;
        }
    }

    public static class GriddataBean {


        private String title;
        private String price;
        private String imageurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
