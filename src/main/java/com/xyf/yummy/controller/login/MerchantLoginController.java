package com.xyf.yummy.controller.login;

import com.xyf.yummy.model.MerchantLog;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.merchant.MerchantManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/5
 * @Time: 21:42
 * @Package: com.xyf.yummy.controller.login
 */
@RestController
@RequestMapping("/yummy/login/merchant")
public class MerchantLoginController {

    @Autowired
    private MerchantManageService manageService;

    @GetMapping("/apply")
    public ModelBean applyCDKey(){
        String cdkey = manageService.apply();
        if(cdkey!=null){
            return new ModelBean(1,"Apply successfully!",cdkey);
        }
        else return new ModelBean(0,"Apply failed!");
    }

    @PostMapping("/register")
    public ModelBean register(@RequestBody MerchantLog log){
        if(manageService.register(log.getCdkey(),log.getPassword())){
            return new ModelBean(1,"Register successfully");
        }
        else return new ModelBean(0,"Cdkey "+log.getCdkey()+" already used! Plz apply for a new one.");
    }

    @PostMapping("/login")
    public ModelBean login(@RequestBody MerchantLog log){
        if(manageService.login(log.getCdkey(),log.getPassword()))
            return new ModelBean(1,"Merchant "+log.getCdkey()+" Login successfully!");
        else return new ModelBean(0,"Incorrect cdkey or password!");
    }
}
