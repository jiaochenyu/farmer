package com.example.farmer.beans;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by jqchen on 2016/5/18.
 */
public class Goods implements Serializable {
    private int goods_id;
    private String goods_name;
    private Uri uri;
    private String goods_brand;
    private String goods_specification;
    private String goods_unit;
    private String goods_shengben;
    private String goods_remark;
    private float goods_market_price;
    private float goods_platform_price;
    private float goods_discount;
    private int goods_comment_count;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Goods(int goods_id, String goods_name, Uri uri, String goods_brand, String goods_specification,
                 String goods_unit, String goods_shengben, String goods_remark, float goods_market_price,
                 float goods_platform_price, float goods_discount, int goods_comment_count) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.uri = uri;
        this.goods_brand = goods_brand;
        this.goods_specification = goods_specification;
        this.goods_unit = goods_unit;
        this.goods_shengben = goods_shengben;
        this.goods_remark = goods_remark;
        this.goods_market_price = goods_market_price;
        this.goods_platform_price = goods_platform_price;
        this.goods_discount = goods_discount;
        this.goods_comment_count = goods_comment_count;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_brand() {
        return goods_brand;
    }

    public void setGoods_brand(String goods_brand) {
        this.goods_brand = goods_brand;
    }

    public String getGoods_specification() {
        return goods_specification;
    }

    public void setGoods_specification(String goods_specification) {
        this.goods_specification = goods_specification;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    public String getGoods_shengben() {
        return goods_shengben;
    }

    public void setGoods_shengben(String goods_shengben) {
        this.goods_shengben = goods_shengben;
    }

    public String getGoods_remark() {
        return goods_remark;
    }

    public void setGoods_remark(String goods_remark) {
        this.goods_remark = goods_remark;
    }

    public float getGoods_market_price() {
        return goods_market_price;
    }

    public void setGoods_market_price(float goods_market_price) {
        this.goods_market_price = goods_market_price;
    }

    public float getGoods_platform_price() {
        return goods_platform_price;
    }

    public void setGoods_platform_price(float goods_platform_price) {
        this.goods_platform_price = goods_platform_price;
    }

    public float getGoods_discount() {
        return goods_discount;
    }

    public void setGoods_discount(float goods_discount) {
        this.goods_discount = goods_discount;
    }

    public int getGoods_comment_count() {
        return goods_comment_count;
    }

    public void setGoods_comment_count(int goods_comment_count) {
        this.goods_comment_count = goods_comment_count;
    }
}
