package com.mall.portal.repository;

import com.mall.portal.domain.MemberProductCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 商品收藏Respository
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection, String> {

    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);

    int deleteByMemberIdAndProductId(Long memberId, Long productId);

    List<MemberProductCollection> findByMemberId(Long memeberId);



}
