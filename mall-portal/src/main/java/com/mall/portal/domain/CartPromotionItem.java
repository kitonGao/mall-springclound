package com.mall.portal.domain;

import com.mall.mbg.entity.OmsCartItem;

import java.math.BigDecimal;

/**
 * @program: mall-springclound
 * @description: 购物车中促销的封装
 * @author: gaojme
 * @create: 2020-04-13 11:20
 */
public class CartPromotionItem extends OmsCartItem{


    /**
     * 促销活动信息
     */
    private String promotionMessage;

    /**
     * 促销活动减去的金额，针对每个商品
     */
    private BigDecimal reduceAmount;

    /**
     * 商品的真实库存(剩余库存-锁定库存)
     */
    private Integer realStock;

    /**
     * 购买商品赠送的积分
     */
    private Integer integration;

    /**
     * 够买商品赠送成长值
     */
    private Integer growth;


    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}
