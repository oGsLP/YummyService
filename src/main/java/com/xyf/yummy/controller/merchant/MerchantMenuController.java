package com.xyf.yummy.controller.merchant;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.model.DishModel;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.PackModel;
import com.xyf.yummy.service.merchant.DishManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/11
 * @Time: 14:28
 * @Package: com.xyf.yummy.controller.merchant
 */
@RestController
@RequestMapping("/yummy/merchant/{mer_id}/menu")
public class MerchantMenuController {

    @Autowired
    private DishManageService dishService;

    @GetMapping("/dishes")
    public ModelBean getDishes(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        List<Dish> dishes = dishService.getDishes(merchantId);
        return new ModelBean(1,"",null,dishes);
    }

    @GetMapping("/packs")
    public ModelBean getPacks(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        List<Pack> packs = dishService.getPacks(merchantId);
        return new ModelBean(1,"",null,packs);
    }

    @PostMapping("/dishes")
    public ModelBean addDish(@PathVariable String mer_id, @RequestBody DishModel dishModel){
        int merchantId = Integer.parseInt(mer_id);
        Dish dish = dishModel.to_Dish(merchantId);
        int sign = dishService.addDish(dish)?1:0;
        return new ModelBean(sign,sign==1?"Add dish successfully!":"Add failed!");
    }

    @PutMapping("/dishes/{dish_id}")
    public ModelBean modifyDish(@PathVariable String mer_id, @PathVariable String dish_id, @RequestBody DishModel dishModel){
        int merchantId = Integer.parseInt(mer_id);
        int dishId = Integer.parseInt(dish_id);
        Dish dish = dishModel.to_Dish(merchantId);
        dish.setId(dishId);
        int sign = dishService.modifyDish(dish)?1:0;
        return new ModelBean(sign,sign==1?"Modify dish successfully!":"Modify failed!");
    }

    @DeleteMapping("/dishes/{dish_id}")
    public ModelBean deleteDish(@PathVariable String dish_id){
        int dishId = Integer.parseInt(dish_id);
        int sign = dishService.deleteDish(dishId)?1:0;
        return new ModelBean(sign,sign==1?"Delete dish successfully!":"Delete failed!");
    }

    @PostMapping("/packs")
    public ModelBean addPack(@PathVariable String mer_id, @RequestBody PackModel packModel){
        int merchantId = Integer.parseInt(mer_id);
        Pack pack = packModel.to_Pack(merchantId);
        int sign = dishService.addPack(pack)?1:0;
        return new ModelBean(sign,sign==1?"Add pack successfully!":"Add failed!");
    }

    @PutMapping("/packs/{pack_id}")
    public ModelBean modifyPack(@PathVariable String mer_id, @PathVariable String pack_id, @RequestBody PackModel packModel){
        int merchantId = Integer.parseInt(mer_id);
        int packId = Integer.parseInt(pack_id);
        Pack pack = packModel.to_Pack(merchantId);
        pack.setId(packId);
        int sign = dishService.modifyPack(pack)?1:0;
        return new ModelBean(sign,sign==1?"Modify pack successfully!":"Modify failed!");
    }

    @DeleteMapping("/packs/{pack_id}")
    public ModelBean deletePack(@PathVariable String pack_id){
        int packId = Integer.parseInt(pack_id);
        int sign = dishService.deletePack(packId)?1:0;
        return new ModelBean(sign,sign==1?"Delete pack successfully!":"Delete failed!");
    }




}
