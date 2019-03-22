package com.xyf.yummy.controller.login;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.MemberLog;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.member.MemberLoginService;
import com.xyf.yummy.service.test.TestService;
import com.xyf.yummy.util.VertificationCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/1
 * @Time: 16:08
 * @Package: com.xyf.yummy.controller.login
 */
@RestController
@RequestMapping("/yummy/login/member")
public class MemberLoginController {

    @Autowired
    private MemberLoginService loginService;

    @PostMapping("/login")
    public ModelBean checkLogin(@RequestBody MemberLog log){
        ModelBean modelBean;
        Member member=loginService.login(log);
        if(member!=null){
            modelBean=new ModelBean(1,"User "+member.getName()+" Login!",member);
        }
        else {
            modelBean=new ModelBean(0,"Not correct email or password, or maybe your account had been cancelled");
        }
        return modelBean;
    }

    @PostMapping("/register")
    public ModelBean register(@RequestBody MemberLog log){
        ModelBean modelBean;
        if(loginService.register(log)){
            modelBean=new ModelBean(1,"Register successfully!");
        }
        else {
            modelBean=new ModelBean(0,"Email already registered or cancelled!");
        }
        return modelBean;
    }

    @PostMapping("/sendCode")
    public ModelBean sendCode(@RequestBody MemberLog log){
        loginService.getKey(log.getEmail());
        return new ModelBean(1,"Already sent!");
    }

}
