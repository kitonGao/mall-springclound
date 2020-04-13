package com.mall.portal.service;

import com.mall.mbg.entity.OmsCartItem;
import com.mall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * 促销管理Service
 */
public interface OmsPromotionService {


    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList  购物车
     * @return
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);



}
