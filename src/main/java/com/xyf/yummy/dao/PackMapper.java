package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.entity.sub.DishInPack;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PackMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Pack record);

    int insertSelective(Pack record);

    Pack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pack record);

    int updateByPrimaryKey(Pack record);

    /**
     *
     * @param id
     * @return
     */
    List<DishInPack> getDishesInPack(Integer id);

    /**
     *
     * @param mer_id
     * @return
     */
    List<Pack> getPacks(Integer mer_id);

    /**
     *
     * @param date
     * @param mer_id
     * @return
     */
    List<Pack> getCurrentPacks(@Param("date") Date date, @Param("mer_id") Integer mer_id);

    /**
     *
     * @param pack_id
     * @param dish_id
     * @return
     */
    int addDishPack(@Param("pack_id") Integer pack_id, @Param("dish_id") Integer dish_id,@Param("num")Integer num);

    /**
     *
     * @param pack_id
     * @return
     */
    int deleteDishPack(Integer pack_id);
}