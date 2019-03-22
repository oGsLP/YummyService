package com.xyf.yummy.controller.admin;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.entity.Profit;
import com.xyf.yummy.model.ApplyModel;
import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.MerchantVerEnum;
import com.xyf.yummy.service.admin.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/19
 * @Time: 14:05
 * @Package: com.xyf.yummy.controller.admin
 */
@RestController
@RequestMapping("/yummy/admin/manage")
public class AdminManageController {

    @Autowired
    private AdminManageService manageService;

    @GetMapping("/profits")
    public ModelBean getProfits(@RequestParam(value = "type", required = false) String type){
        if(type!=null&&type.equals("all")){
            List<Profit> profits= manageService.getProfits();
            return new ModelBean(1,"",null, profits);
        }
        else {
            double profit = manageService.getProfit();
            return new ModelBean(1,"",profit);
        }
    }

    @PostMapping("/profits")
    public ModelBean putProfit(@RequestParam("profit") double profit){
        manageService.modifyProfit(profit);
        return new ModelBean(1,"Change current profit!");
    }

    @GetMapping("/applies")
    public ModelBean getApplies(){
        List<ApplyModel> applies = manageService.getApplies();
        return new ModelBean(1,"",null,applies);
    }

    @PutMapping("/applies/{mer_id}")
    public ModelBean putApply(@PathVariable String mer_id, @RequestParam("type") String type){
        int merchantId = Integer.parseInt(mer_id);
        if(type.equals(MerchantVerEnum.GET_DISAPPROVAL.toString())){
            manageService.failApply(merchantId);
            return new ModelBean(1,"Reject this apply!");
        }
        else if(type.equals(MerchantVerEnum.AFTER_VERTIFICATION.toString())){
            manageService.passApply(merchantId);
            return new ModelBean(1,"Approve this apply!");
        }
        else return new ModelBean(0,"Wrong request!");
    }

    @GetMapping("/discounts")
    public ModelBean getDiscounts(){
        List<MemberDiscount> discounts = manageService.getMemberDiscounts();
        return new ModelBean(1,"",null,discounts);
    }

    @PutMapping("/discounts")
    public ModelBean putDiscounts(@RequestBody List<MemberDiscount> discounts){
        manageService.modifyMemberDiscounts(discounts);
        return new ModelBean(1,"Modified level discounts!");
    }

}
