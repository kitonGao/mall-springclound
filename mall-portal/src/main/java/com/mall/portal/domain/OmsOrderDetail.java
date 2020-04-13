package com.mall.portal.domain;

import com.mall.mbg.entity.OmsOrder;
import com.mall.mbg.entity.OmsOrderItem;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 包含订单商品信息的订单详情
 * @author: gaojme
 * @create: 2020-04-13 13:56
 */
public class OmsOrderDetail extends OmsOrder{

    private List<OmsOrderItem> orderItemList;



    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
