package com.mall.portal.service;

import com.mall.mbg.entity.CmsSubject;
import com.mall.mbg.entity.PmsProduct;
import com.mall.mbg.entity.PmsProductCategory;
import com.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理Service
 */
public interface HomeService {

    /**
     * 获取首页内容
     * @return
     */
    HomeContentResult content();


    /**
     * 首页商品推荐
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);


    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类， 其他：获取指定二级分类
     * @return
     */
    List<PmsProductCategory> getProductCateList(Long parentId);


    /**
     * 根据专题分类分页获取专题
     * @param cateId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);









}
