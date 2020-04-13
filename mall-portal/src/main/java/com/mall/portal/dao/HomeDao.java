package com.mall.portal.dao;

import com.mall.mbg.entity.CmsSubject;
import com.mall.mbg.entity.PmsBrand;
import com.mall.mbg.entity.PmsProduct;
import com.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 首页商品内容管理自定义DAO
 * @author: gaojme
 * @create: 2020-04-13 14:08
 */
public interface HomeDao {


    /**
     * 获取推荐品牌
     * @param offset
     * @param limit
     * @return
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 获取秒杀商品
     * @param flashPromotionId
     * @param sessionId
     * @return
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId")Long sessionId);


    /**
     * 获取新品推荐
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getNewProductList(@Param("offset")Integer offset, @Param("limit")Integer limit);

    /**
     * 获取人气推荐
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getHotProductList(@Param("offset")Integer offset, @Param("limit")Integer limit);


    /**
     * 获取推荐专题
     * @param offset
     * @param limit
     * @return
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset")Integer offset, @Param("limit")Integer limit);



}
