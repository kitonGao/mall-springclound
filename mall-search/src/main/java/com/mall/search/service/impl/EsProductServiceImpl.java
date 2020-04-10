package com.mall.search.service.impl;

import com.mall.search.domain.EsProduct;
import com.mall.search.domain.EsProductRelatedInfo;
import com.mall.search.service.EsProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-10 09:59
 */
@Service
public class EsProductServiceImpl implements EsProductService{


    @Override
    public int importAll() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public EsProduct create(Long id) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort) {
        return null;
    }

    @Override
    public Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public EsProductRelatedInfo searchRelatedInfo(String keyword) {
        return null;
    }
}
