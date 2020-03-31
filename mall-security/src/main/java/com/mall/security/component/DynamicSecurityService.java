package com.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @program: mall-springclound
 * @description: 动态权限相关业务类
 * @author: gaojme
 * @create: 2020-03-30 18:06
 */
public interface DynamicSecurityService {


    /**
     * 加载资源ANT通配符和资源对应MAP
     * @return
     */
    Map<String,ConfigAttribute> loadDataSource();



}
