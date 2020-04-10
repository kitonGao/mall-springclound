package com.mall.search.dao;

import com.mall.search.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 搜索系统中的商品管理自定义Dao
 * @author: gaojme
 * @create: 2020-04-10 09:06
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);


}
