package com.mall.portal.service;

import com.mall.mbg.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 用户地址管理Service
 */
public interface UmsMemberReceiveAddressService {

    /**
     * 添加收货地址
     * @param address
     * @return
     */
    int add(UmsMemberReceiveAddress address);


    /**
     * 删除收货地址
     * @param id
     * @return
     */
    int delete(Long id);


    /**
     * 修改收货地址
     * @param id  地址表的id
     * @param address   修改的收货地址信息
     * @return
     */
    int update(Long id, UmsMemberReceiveAddress address);


    /**
     * 返回当前用户的收货地址
     * @return
     */
    List<UmsMemberReceiveAddress> list();


    /**
     * 获取地址详情
     * @param id
     * @return
     */
    UmsMemberReceiveAddress getItem(Long id);




}
