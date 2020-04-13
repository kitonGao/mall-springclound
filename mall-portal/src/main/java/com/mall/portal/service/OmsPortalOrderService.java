package com.mall.portal.service;

import com.mall.portal.domain.ConfirmOrderReulst;
import com.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 前台订单管理Service
 */
public interface OmsPortalOrderService {

    /**
     * 根据用户购物车信息生成确认订单信息
     * @return
     */
    ConfirmOrderReulst generateConfirmOrder();


    /**
     * 根据提交信息生成订单
     * @param orderParam
     * @return
     */
    @Transactional
    Map<String,Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     * @param orderId
     * @return
     */
    @Transactional
    Integer paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     * @return
     */
    @Transactional
    Integer cancelTimeOutOrder();


    /**
     * 取消某个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);


    /**
     * 发送延迟消息取消订单
     * @param orderId
     */
    void sendDelayMessageCancelOrder(Long orderId);







}
