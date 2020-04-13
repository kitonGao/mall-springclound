package com.mall.portal.controller;

import com.mall.common.api.CommonResult;
import com.mall.mbg.entity.CmsSubject;
import com.mall.mbg.entity.PmsProduct;
import com.mall.mbg.entity.PmsProductCategory;
import com.mall.portal.domain.HomeContentResult;
import com.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 首页内容管理Controller
 * @author: gaojme
 * @create: 2020-04-13 18:27
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;


    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/context", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeContentResult> context(){
        HomeContentResult content = homeService.content();
        return CommonResult.success(content);
    }



    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4")Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum) {
        List<PmsProduct> pmsProductList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(pmsProductList);
    }


    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCateList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCateList);
    }


    @ApiOperation("根据分类获取专题")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> getSubjectList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "4")Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId, pageSize, pageNum);
        return CommonResult.success(subjectList);
    }





}
