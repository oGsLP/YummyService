package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    /**
     * 用户的地址列表查询
     * @param mem_id
     * @return
     */
    List<Address> findAddressesByMemberId(Integer mem_id);

    /**
     * 关联表增加
     * @param mem_id
     * @param ad_id
     * @return
     */
    int addMemberAddress(@Param("mem_id") Integer mem_id, @Param("ad_id") Integer ad_id);

    /**
     * 关联表删除
     * @param mem_id
     * @param ad_id
     * @return
     */
    int deleteMemberAddress(@Param("mem_id") Integer mem_id, @Param("ad_id") Integer ad_id);
}