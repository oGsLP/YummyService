package com.xyf.yummy.controller.member;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.model.DealModel;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.shop.DealManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/6
 * @Time: 17:17
 * @Package: com.xyf.yummy.controller.member
 */
@RestController
@RequestMapping("/yummy/member/{mem_id}/deals")
public class MemberDealController {
    @Autowired
    DealManageService dealManageService;

    @GetMapping("")
    public ModelBean getDeals(@PathVariable String mem_id,
                              @RequestParam(value = "type", required = false) String type){
        int memberId = Integer.parseInt(mem_id);
        if(type==null)
            return new ModelBean(1,"", null, dealManageService.getMemberDeals(memberId));
        else{
            DealStateEnum state = DealStateEnum.getJsonEnum(type);
            return new ModelBean(1,"",null,dealManageService.getMemberDeals(memberId,state));
        }
    }



    @PostMapping("")
    public ModelBean generateDeal(@PathVariable String mem_id, @RequestParam(value = "mer_id") int merchantId, @RequestBody DealModel dealModel){
        Deal deal = dealModel.to_Deal(Integer.parseInt(mem_id),merchantId);
        int code = dealManageService.generateDeal(deal)?1:0;
        return new ModelBean(code,code==1?"Deal created!":"Deal failed!",deal);
    }

    @PutMapping("/{deal_id}")
    public ModelBean putDeal(@RequestParam(value = "put_type") String type,
                             @PathVariable String deal_id){
        int dealId = Integer.parseInt(deal_id);
        String msg =""; int code = 0;
        if(type.equals(DealStateEnum.CANCELLED.toString())){
            code = dealManageService.cancelDeal(dealId)?1:0;
            msg = code==1?"Cancel success!":"Cancel failed!";
        }
        else if (type.equals(DealStateEnum.ACCOUNT_PAID.toString())){
            code = dealManageService.payDeal(dealId)?1:0;
            msg = code==1?"Pay success! Waiting for delivery!":"Pay failed!";
        }
        else if (type.equals(DealStateEnum.REFUNDED.toString())){
            code = dealManageService.refundDeal(dealId)?1:0;
            msg = code==1?"Refund success!":"Refund failed!";
        }
        else if(type.equals(DealStateEnum.RECEIVED.toString())){
            code = dealManageService.completeDeal(dealId)?1:0;
            msg = code==1?"Complete success!":"Complete failed!";
        }
        return new ModelBean(code,msg);
    }



}
