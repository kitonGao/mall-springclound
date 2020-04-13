package com.mall.portal.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: mall-springclound
 * @description: 会员关注的品牌
 * @author: gaojme
 * @create: 2020-04-13 13:44
 */
@Document
public class MemberBrandAttention {

    @Id
    private String id;

    private Long memberId;

    private String memberNickname;

    private String memberIcon;

    @Indexed
    private Long brandId;

    private String brandLogo;

    private String brandCity;

    private Integer brandAttentionCount;

    private Date createTime;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandCity() {
        return brandCity;
    }

    public void setBrandCity(String brandCity) {
        this.brandCity = brandCity;
    }

    public Integer getBrandAttentionCount() {
        return brandAttentionCount;
    }

    public void setBrandAttentionCount(Integer brandAttentionCount) {
        this.brandAttentionCount = brandAttentionCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
