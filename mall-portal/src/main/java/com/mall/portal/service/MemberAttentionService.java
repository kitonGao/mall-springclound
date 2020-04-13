package com.mall.portal.service;

import com.mall.portal.domain.MemberBrandAttention;

import java.util.List;

/**
 * 会员关注Service
 */
public interface MemberAttentionService {

    /**
     * 添加关注
     * @param memberBrandAttention
     * @return
     */
    int add(MemberBrandAttention memberBrandAttention);


    /**
     * 取消关注
     * @param memberId
     * @param brandId
     * @return
     */
    int delete(Long memberId, Long brandId);


    /**
     * 获取用户关注列表
     * @param memberId
     * @return
     */
    List<MemberBrandAttention> list(Long memberId);



}
