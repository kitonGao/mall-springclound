package com.mall.portal.domain;

import com.mall.mbg.entity.PmsProduct;
import com.mall.mbg.entity.PmsProductFullReduction;
import com.mall.mbg.entity.PmsProductLadder;
import com.mall.mbg.entity.PmsSkuStock;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 商品的促销信息，包括sku，打折优惠，满减优惠
 * @author: gaojme
 * @create: 2020-04-13 14:06
 */
public class PromotionProduct extends PmsProduct {

    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> pmsProductFullReductionList;


    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<PmsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<PmsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<PmsProductFullReduction> getPmsProductFullReductionList() {
        return pmsProductFullReductionList;
    }

    public void setPmsProductFullReductionList(List<PmsProductFullReduction> pmsProductFullReductionList) {
        this.pmsProductFullReductionList = pmsProductFullReductionList;
    }
}
