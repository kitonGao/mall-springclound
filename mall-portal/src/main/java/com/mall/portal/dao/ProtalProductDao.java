package com.mall.portal.dao;

import com.mall.portal.domain.CartProduct;
import com.mall.portal.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 */
public interface ProtalProductDao {


    CartProduct getCartProduct(@Param("id")Long id);


    List<PromotionProduct> getPromotionProductList(@Param("ids")List<Long> ids);


}
