package com.xyf.yummy.controller.member;

import com.xyf.yummy.entity.MemberConsumption;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.admin.MemberDataGatherService;
import com.xyf.yummy.service.member.MemberLoginService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/14
 * @Time: 11:49
 * @Package: com.xyf.yummy.controller.member
 */
@RestController
@RequestMapping("/yummy/member/{mem_id}/stat")
public class MemberStatController {

    @Autowired
    private MemberDataGatherService dataGatherService;

    @Autowired
    private MemberLoginService loginService;

    @GetMapping("")
    public ModelBean getStat(@PathVariable String mem_id){
        int memberId = Integer.parseInt(mem_id);
        MemberConsumption consumption = dataGatherService.getConsumption(memberId);
        List<Merchant> list = dataGatherService.getMostUsually(memberId);
        return new ModelBean(1,"",consumption,list);
    }

    @PutMapping("/account")
    public ModelBean cancelAccount(@PathVariable String mem_id){
        int memberId = Integer.parseInt(mem_id);
        loginService.cancelAccount(memberId);
        return new ModelBean(1,"Your Account has been cancelled. All Data will be stored...");
    }
}
