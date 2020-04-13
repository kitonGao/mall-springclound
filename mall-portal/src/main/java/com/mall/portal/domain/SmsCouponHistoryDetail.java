package com.mall.portal.domain;

import com.mall.mbg.entity.SmsCoupon;
import com.mall.mbg.entity.SmsCouponHistory;
import com.mall.mbg.entity.SmsCouponProductCategoryRelation;
import com.mall.mbg.entity.SmsCouponProductRelation;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 优惠券领取历史详情封装
 * @author: gaojme
 * @create: 2020-04-13 13:32
 */
public class SmsCouponHistoryDetail extends SmsCouponHistory{

    /**
     * 相关优惠券信息
     */
    private SmsCoupon coupon;

    /**
     * 优惠券关联商品
     */
    private List<SmsCouponProductRelation> productRelationList;

    /**
     * 优惠券关联商品分类
     */
    private List<SmsCouponProductCategoryRelation> categoryRelationList;


    public SmsCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(SmsCoupon coupon) {
        this.coupon = coupon;
    }

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getCategoryRelationList() {
        return categoryRelationList;
    }

    public void setCategoryRelationList(List<SmsCouponProductCategoryRelation> categoryRelationList) {
        this.categoryRelationList = categoryRelationList;
    }
}
