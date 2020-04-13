package com.mall.portal.service;

import com.mall.mbg.entity.SmsCouponHistory;
import com.mall.portal.domain.CartPromotionItem;
import com.mall.portal.domain.SmsCouponHistoryDetail;

import java.util.List;

/**
 * 用户优惠券管理Service
 */
public interface UmsMemberCouponService {


    /**
     * 会员添加优惠券
     * @param couponId
     */
    void add(Long couponId);

    /**
     * 获取优惠券列表
     * @param useStatus
     * @return
     */
    List<SmsCouponHistory> list(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     * @param cartPromotionItemList
     * @param type
     * @return
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartPromotionItemList, Integer type);




}
