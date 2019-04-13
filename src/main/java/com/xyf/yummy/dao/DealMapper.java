package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.sub.DealDish;
import com.xyf.yummy.entity.sub.DealPack;
import com.xyf.yummy.model.enums.DealStateEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Deal record);

    int insertSelective(Deal record);

    Deal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Deal record);

    int updateByPrimaryKey(Deal record);

    /**
     *
     * @param id
     * @return
     */
    List<DealDish> getDishesInDeal(Integer id);

    /**
     *
     * @param id
     * @return
     */
    List<DealPack> getPacksInDeal(Integer id);

    /**
     *
     * @param deal_id
     * @param dish_id
     * @param num
     * @return
     */
    void insertDishInDeal(@Param("deal_id") Integer deal_id, @Param("dish_id") Integer dish_id, @Param("num") Integer num);

    /**
     *
     * @param deal_id
     * @param pack_id
     * @param num
     * @return
     */
    void insertPackInDeal(@Param("deal_id") Integer deal_id, @Param("pack_id") Integer pack_id, @Param("num") Integer num);

    /**
     *
     * @param id
     * @param state
     * @return
     */
    int changeState(@Param("id") Integer id, @Param("state") DealStateEnum state);

    /**
     *
     * @param mer_id
     * @return
     */
    List<Deal> getDealsByMerchantId(Integer mer_id);

    /**
     *
     * @param mem_id
     * @return
     */
    List<Deal> getDealsByMemberId(Integer mem_id);

    /**
     *
     * @param state
     * @return
     */
    List<Deal> getDealsByState(DealStateEnum state);

    /**
     *
     * @return
     */
    List<Deal> getDeals();

    /**
     *
     * @param mem_id
     * @param state
     * @return
     */
    List<Deal> getMemberDealsByState(@Param("mem_id") Integer mem_id, @Param("state") DealStateEnum state);

    /**
     *
     * @param mer_id
     * @param state
     * @return
     */
    List<Deal> getMerchantDealsByState(@Param("mer_id") Integer mer_id, @Param("state") DealStateEnum state);

    /**
     *
     * @param mer_id
     * @param state
     * @return
     */
    double getComplete(@Param("mer_id") Integer mer_id, @Param("state") DealStateEnum state);

    /**
     *
     * @param mer_id
     * @param state
     * @return
     */
    double getTotal(@Param("mer_id") Integer mer_id, @Param("state") DealStateEnum state);

    /**
     *
     * @param mer_id
     * @param state
     * @return
     */
    double getRefund(@Param("mer_id") Integer mer_id, @Param("state") DealStateEnum state);

    /**
     *
     * @param state
     * @return
     */
    double getProfit(DealStateEnum state);


}