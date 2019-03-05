package com.xyf.yummy.controller.login;

import com.xyf.yummy.model.AdminCode;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.admin.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/5
 * @Time: 22:08
 * @Package: com.xyf.yummy.controller.login
 */
@RestController
@RequestMapping("/yummy/admin")
public class AdminLoginController {

    @Autowired
    private AdminManageService manageService;

    @PostMapping("/login")
    public ModelBean login(@RequestBody AdminCode adminCode){
        if(1==1)
            return new ModelBean(1,"Welcome Admin");
        else return new ModelBean(0,"Wrong identification! You're not allowed to access");
    }
}
