package com.xyf.yummy.controller.member;

import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.dao.PackMapper;
import com.xyf.yummy.entity.*;
import com.xyf.yummy.entity.sub.DishInPack;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.shop.DealManageService;
import com.xyf.yummy.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private DealManageService dealManageService;

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

    @PostMapping("/{mer_id}/distance")
    public ModelBean checkDistance(@PathVariable String mer_id,
                                   @RequestBody Address address, @RequestParam("time") int time){
        int merchantId = Integer.parseInt(mer_id);
        boolean sign=dealManageService.checkDistance(address,merchantId,time);
        return new ModelBean(sign?1:0,sign?"":"time is not enough for this deal's distance!");
    }
}
