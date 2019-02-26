package com.xyf.yummy.service.merchant;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:51
 * @Package: com.xyf.yummy.service
 */
public interface DishManageService {

    /**
     *
     * @param mer_id
     * @return
     */
    List<Dish> getDishes(int mer_id);

    /**
     *
     * @param dish
     * @return
     */
    boolean addDish(Dish dish);

    /**
     *
     * @param dish
     * @return
     */
    boolean modifyDish(Dish dish);

    /**
     *
     * @param dish_id
     * @return
     */
    boolean deleteDish(int dish_id);


    /**
     *
     * @param mer_id
     * @return
     */
    List<Pack> getPacks(int mer_id);

    /**
     *
     * @param pack
     * @return
     */
    boolean addPack(Pack pack);

    /**
     *
     * @param pack
     * @return
     */
    boolean modifyPack(Pack pack);

    /**
     *
     * @param pack_id
     * @return
     */
    boolean deletePack(int pack_id);


}
