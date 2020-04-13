package com.mall.portal.service.impl;

import com.mall.mbg.entity.CmsSubject;
import com.mall.mbg.entity.PmsProduct;
import com.mall.mbg.entity.PmsProductCategory;
import com.mall.portal.domain.HomeContentResult;
import com.mall.portal.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-13 18:36
 */
@Service
public class HomeServiceImpl implements HomeService {


    @Override
    public HomeContentResult content() {
        return null;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        return null;
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        return null;
    }
}
