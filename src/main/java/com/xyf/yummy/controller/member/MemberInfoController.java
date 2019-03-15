package com.xyf.yummy.controller.member;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.MemberPayment;
import com.xyf.yummy.model.MemberInfo;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.PaymentModel;
import com.xyf.yummy.service.member.MemberManageService;
import com.xyf.yummy.service.member.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/6
 * @Time: 14:53
 * @Package: com.xyf.yummy.controller.member
 */
@RestController
@RequestMapping("/yummy/member/{mem_id}/info")
public class MemberInfoController {

    @Autowired
    private MemberManageService manageService;
    @Autowired
    private PayService payService;

    @GetMapping("/info")
    public ModelBean getInfo(@PathVariable("mem_id") String userId){
        int id = Integer.parseInt(userId);
        MemberInfo info = manageService.getInfo(id);
        return new ModelBean(1,"",info);
    }

    @PutMapping("/info")
    public ModelBean modifyInfo(@PathVariable("mem_id") String userId, @RequestBody MemberInfo memberInfo){
        int id = Integer.parseInt(userId);
        manageService.modifyInfo(id,memberInfo);
        return new ModelBean(1,"Modified!");
    }

    @GetMapping("/addresses")
    public ModelBean getAddress(@PathVariable("mem_id") String userId){
        int id = Integer.parseInt(userId);
        List<Address> addresses = manageService.getAddresses(id);
        return new ModelBean(1,"",null,addresses);
    }

    @PostMapping("/address")
    public ModelBean addAddress(@PathVariable("mem_id") String mem_id, @RequestBody Address address){
        int memberId = Integer.parseInt(mem_id);
        int sign = manageService.addAddress(memberId,address) ? 1: 0;
        return new ModelBean(sign,sign==1?"Add successfully":"Add failed");
    }

    @DeleteMapping("/address/{ad_id}")
    public ModelBean deleteAddress(@PathVariable("mem_id") String mem_id, @PathVariable String ad_id){
        int memberId = Integer.parseInt(mem_id);
        int addressId = Integer.parseInt(ad_id);
        int sign = manageService.deleteAddress(memberId,addressId) ? 1: 0;
        return new ModelBean(sign,sign==1?"Delete successfully":"Delete failed");
    }

}
