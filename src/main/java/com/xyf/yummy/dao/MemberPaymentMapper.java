package com.xyf.yummy.dao;

import com.xyf.yummy.entity.MemberPayment;
import org.apache.ibatis.annotations.Param;

public interface MemberPaymentMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPayment record);

    int insertSelective(MemberPayment record);

    MemberPayment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPayment record);

    int updateByPrimaryKey(MemberPayment record);

    /**
     * 得到用户的pay账户
     * @param mem_id
     * @return
     */
    MemberPayment findPaymentByMemberId(Integer mem_id);

    /**
     * 检查用户账户,不对则返回null
     * @param mem_id
     * @param account
     * @param password
     * @return
     */
    MemberPayment checkAccount(@Param("mem_id") Integer mem_id, @Param("account") String account, @Param("password") String password);

    /**
     * 得到账户余额
     * @param id
     * @return
     */
    double getBalance(Integer id);

    /**
     * 更新账户余额
     * @param id
     * @param balance
     * @return
     */
    int updateBalance(@Param("id") Integer id, @Param("balance") double balance);

}