package com.xyf.yummy.controller.member;

import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.dao.PackMapper;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.MerchantDiscount;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.entity.sub.DishInPack;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/6
 * @Time: 16:34
 * @Package: com.xyf.yummy.controller.member
 */
@RestController
@RequestMapping("/yummy/member/{mem_id}/merchants")
public class MemberShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private PackMapper packMapper;
    @Autowired
    private MerchantMapper merchantMapper;

    @GetMapping("")
    public ModelBean getMerchants(@PathVariable String mem_id){
        List merchants = shopService.getMerchants();
        return new ModelBean(1,"",null,merchants);
    }

    @GetMapping("/{mer_id}/dishes")
    public ModelBean getMerchantDishes(@PathVariable String mer_id, @PathVariable String mem_id){
        int merchantId = Integer.parseInt(mer_id);
        //todo
        List<Dish> dishes = shopService.getCurrentDishes(merchantId);
        return new ModelBean(1,"",null,dishes);
    }

    @GetMapping("/{mer_id}/packs")
    public ModelBean getMerchantPacks(@PathVariable String mer_id, @PathVariable String mem_id){
        int merchantId = Integer.parseInt(mer_id);
        //todo
        List<Pack> packs = shopService.getCurrentPacks(merchantId);
        return new ModelBean(1,"",null,packs);
    }

    @GetMapping("/{mer_id}/packs/{pack_id}")
    public ModelBean getPack(@PathVariable String pack_id, @PathVariable String mem_id, @PathVariable String mer_id){
        int packId = Integer.parseInt(pack_id);
        List<DishInPack> dishInPacks = packMapper.getDishesInPack(packId);
        Map<String,Integer> map = new HashMap<>();
        for(DishInPack dishInPack: dishInPacks){
            map.put(dishInPack.getDish().getName(), dishInPack.getNum());
        }
        return new ModelBean(1,"",map);
    }

    @GetMapping("/{mer_id}/discounts")
    public ModelBean getDiscount(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        MerchantDiscount discount = merchantMapper.selectByPrimaryKey(merchantId).getDiscount();
        return new ModelBean(1,"",discount);
    }
}
