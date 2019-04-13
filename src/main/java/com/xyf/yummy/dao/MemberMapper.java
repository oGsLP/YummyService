package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.enums.MemLvEnum;
import com.xyf.yummy.model.enums.MemValEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    /**
     * 返回email对应用户的有效状态，不存在用户则返回null
     * @param email
     * @return
     */
    MemValEnum checkAccount(String email);

    /**
     * 通过账户密码得到用户,密码不正确则返回null
     * @param email
     * @param password
     * @param validation
     * @return
     */
    Member checkLogin(@Param("email") String email, @Param("password") String password,@Param("validation") MemValEnum validation);

    /**
     * 通过email获取用户Id
     * @param email
     * @return
     */
    Integer getIdByEmail(String email);

    /**
     * 设置用户有效状态
     * @param id
     */
    void cancelAccount(@Param("id") Integer id, @Param("validation") MemValEnum val);

    /**
     *
     * @param valEnum
     * @return
     */
    List<Member> getMemberOfOneValidation(MemValEnum valEnum);

    /**
     *
     * @param lvEnum
     * @return
     */
    List<Member> getMemberOfOneLevel(MemLvEnum lvEnum);


    /**
     *
     * @param mer_id
     * @return
     */
    List<Member> getMostUsuallyMembers(Integer mer_id);

}