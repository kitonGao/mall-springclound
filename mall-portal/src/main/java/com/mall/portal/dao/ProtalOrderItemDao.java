package com.mall.portal.dao;

import com.mall.mbg.entity.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品信息自定义Dao
 */
public interface ProtalOrderItemDao {


    int insertList(@Param("list")List<OmsOrderItem> list);


}
