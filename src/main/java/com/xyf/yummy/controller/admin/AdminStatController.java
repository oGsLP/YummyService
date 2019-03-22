package com.xyf.yummy.controller.admin;

import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.*;
import com.xyf.yummy.service.admin.AdminDataGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/19
 * @Time: 14:05
 * @Package: com.xyf.yummy.controller.admin
 */
@RestController
@RequestMapping("/yummy/admin/stat")
public class AdminStatController {
    @Autowired
    private AdminDataGatherService dataGatherService;

    @GetMapping("/members")
    public ModelBean getMembers(@RequestParam(value = "lvEnum", required = false)MemLvEnum lvEnum,
                                @RequestParam(value = "valEnum", required = false)MemValEnum valEnum){
        if(lvEnum != null){
            List<Member> list = dataGatherService.getMembersByLevel(lvEnum);
            return new ModelBean(1,"",null,list);
        }
        else if(valEnum!=null){
            List<Member> list = dataGatherService.getMembersByValidation(valEnum);
            return new ModelBean(1,"",null,list);
        }
        else return new ModelBean(0,"");
    }

    @GetMapping("/merchants")
    public ModelBean getMerchants(@RequestParam(value = "typeEnum",required = false)MerchantTypeEnum typeEnum,
                                  @RequestParam(value = "verEnum", required = false)MerchantVerEnum verEnum){
        if(typeEnum!=null){
            List<Merchant> list = dataGatherService.getMerchantsByType(typeEnum);
            return new ModelBean(1,"",null,list);
        }
        else if(verEnum!=null){
            List<Merchant> list = dataGatherService.getMerchantsByVertification(verEnum);
            return new ModelBean(1,"",null,list);
        }
        else return new ModelBean(0,"");
    }

    @GetMapping("/deals")
    public ModelBean getDeals(@RequestParam(value = "stateEnum")DealStateEnum stateEnum){
        List<Deal> deals = dataGatherService.getDealsByState(stateEnum);
        return new ModelBean(1,"",null,deals);
    }

    @GetMapping("/profits")
    public ModelBean getProfit(){
        Double profit = dataGatherService.getProfit();
        return new ModelBean(1,"",profit);
    }
}
