package com.xyf.yummy.controller;

import com.xyf.yummy.model.MemberLog;
import com.xyf.yummy.model.MyResult;
import com.xyf.yummy.service.member.MemberLoginService;
import com.xyf.yummy.service.member.MemberManageService;
import com.xyf.yummy.service.test.TestService;
import com.xyf.yummy.util.VertificationCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.controller
 */
@Controller
@RequestMapping("/yummy/memr")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private MemberLoginService loginService;
    @ResponseBody
    @PostMapping("/login")
    public MyResult login(@RequestBody MemberLog log){
        MyResult result=new MyResult();
        return result;
    }
}

