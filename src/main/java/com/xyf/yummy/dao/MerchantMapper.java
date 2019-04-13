package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.enums.MerchantTypeEnum;
import com.xyf.yummy.model.enums.MerchantVerEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    /**
     * 获得所有商家信息
     * @return
     */
    List<Merchant> getAllMerchants();


    /**
     * 商家账户登录检查,账户密码错误则返回null
     * @param cdkey
     * @param password
     * @return
     */
    Merchant checkLogin(@Param("cdkey") String cdkey, @Param("password") String password);

    /**
     * 通过标识码获得商家信息
     * @param cdkey
     * @return
     */
    Merchant getMerchantByCdkey(String cdkey);

    /**
     *
     * @param mer_id
     * @param verEnum
     * @return
     */
    void changeVertification(@Param("mer_id") Integer mer_id ,@Param("verEnum") MerchantVerEnum verEnum);

    /**
     *
     * @param verEnum
     * @return
     */
    List<Merchant> getMerchantOfOneVertification(MerchantVerEnum verEnum);

    /**
     *
     * @param typeEnum
     * @return
     */
    List<Merchant> getMerchantOfOneType(MerchantTypeEnum typeEnum);

    /**
     *
     * @param mem_id
     * @return
     */
    List<Merchant> getMostUsuallyMerchants(Integer mem_id);
}