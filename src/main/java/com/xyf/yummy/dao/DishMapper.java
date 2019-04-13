package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DishMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);

    /**
     *
     * @param mer_id
     * @return
     */
    List<Dish> getDishes(Integer mer_id);

    /**
     *
     * @param date
     * @param mer_id
     * @return
     */
    List<Dish> getCurrentDishes(@Param("date") Date date, @Param("mer_id") Integer mer_id);
}