package com.mall.portal.domain;

import com.mall.mbg.entity.PmsProduct;
import com.mall.mbg.entity.PmsProductAttribute;
import com.mall.mbg.entity.PmsSkuStock;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 购物车中选择规格的商品信息
 * @author: gaojme
 * @create: 2020-04-10 17:12
 */
public class CartProduct extends PmsProduct{

    private List<PmsProductAttribute> productAttributeList;

    private List<PmsSkuStock> skuStockList;


    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }
}
