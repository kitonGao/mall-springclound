package com.mall.portal.domain;

import java.util.Date;
import java.util.List;

/**
 * @program: mall-springclound
 * @description: 首页当前秒杀场次信息
 * @author: gaojme
 * @create: 2020-04-13 13:43
 */
public class HomeFlashPromotion {

    private Date startTime;

    private Date endTime;

    private Date nextStartTime;

    private Date nextEndTime;

    //属于该秒杀活动的商品
    private List<FlashPromotionProduct> promotionProductList;


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextStartTime() {
        return nextStartTime;
    }

    public void setNextStartTime(Date nextStartTime) {
        this.nextStartTime = nextStartTime;
    }

    public Date getNextEndTime() {
        return nextEndTime;
    }

    public void setNextEndTime(Date nextEndTime) {
        this.nextEndTime = nextEndTime;
    }

    public List<FlashPromotionProduct> getPromotionProductList() {
        return promotionProductList;
    }

    public void setPromotionProductList(List<FlashPromotionProduct> promotionProductList) {
        this.promotionProductList = promotionProductList;
    }
}
