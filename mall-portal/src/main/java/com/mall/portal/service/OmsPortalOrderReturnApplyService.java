package com.mall.portal.service;

import com.mall.portal.domain.OmsOrderReturnApplyParam;

/**
 * 订单退货管理Service
 */
public interface OmsPortalOrderReturnApplyService {


    /**
     * 提交申请
     * @param returnApply
     * @return
     */
    int create(OmsOrderReturnApplyParam returnApply);



}
