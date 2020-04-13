package com.mall.portal.dao;

import com.mall.portal.domain.SmsCouponHistoryDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 会员优惠券领取历史自定义Dao
 * @author: gaojme
 * @create: 2020-04-13 14:09
 */
public interface SmsCouponHistoryDao {


    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId")Long memberId);


}
