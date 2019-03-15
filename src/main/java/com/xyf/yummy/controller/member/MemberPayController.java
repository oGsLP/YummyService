package com.xyf.yummy.controller.member;

import com.xyf.yummy.entity.MemberPayment;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.PaymentModel;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.member.PayService;
import com.xyf.yummy.service.shop.DealManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/14
 * @Time: 15:43
 * @Package: com.xyf.yummy.controller.member
 */
@RestController
@RequestMapping("/yummy/member/{mem_id}/payment")
public class MemberPayController {

    @Autowired
    private PayService payService;

    @GetMapping("")
    public ModelBean getPayment(@PathVariable("mem_id") String mem_id){
        int memberId = Integer.parseInt(mem_id);
        MemberPayment payment = payService.getPayment(memberId);
        if(payment!=null){
            payment.setPassword(null);
            return new ModelBean(1,"",payment);
        }
        else return new ModelBean(0,"Haven't got payment yet!");
    }
    @PostMapping("")
    public ModelBean addPayment(@PathVariable("mem_id") String mem_id, @RequestBody PaymentModel paymentModel){
        int memberId = Integer.parseInt(mem_id);
        boolean sign = payService.addPayment(memberId,paymentModel.getAccount(),paymentModel.getPassword());
        if(sign) return new ModelBean(1,"Payment Added!");
        else return new ModelBean(0,"Add failed!");
    }

    @PutMapping("/deals")
    public ModelBean payDeal(@PathVariable("mem_id") String mem_id, @RequestBody PaymentModel paymentModel,
                             @RequestParam("deal_id") int dealId ,@RequestParam("type") String type){
        int memberId = Integer.parseInt(mem_id);
        int sign = payService.checkPayment(memberId,paymentModel.getAccount(),paymentModel.getPassword())?1:0;
        String msg = sign==1?"":"Incorrect password";
        if(sign==1){
            if(type.equals("pay")){
                sign = payService.pay(memberId,dealId)?1:0;
                msg = sign==1?"Pay success!":"Balance insufficient!";
            }
            else {
                sign = payService.refund(memberId,dealId)?1:0;
                msg = sign==1?"Refund success!":"Refund failed!";
            }
        }
        return new ModelBean(sign,msg);
    }
}
