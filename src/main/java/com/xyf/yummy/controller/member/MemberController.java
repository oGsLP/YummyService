package com.xyf.yummy.controller.member;

import com.xyf.yummy.model.MemberLog;
import com.xyf.yummy.model.MyResult;
import com.xyf.yummy.service.member.MemberLoginService;
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
 * @Date: 2019/3/1
 * @Time: 16:08
 * @Package: com.xyf.yummy.controller.member
 */
@Controller
@RequestMapping("/yummy/member")
public class MemberController {
    @Autowired
    private TestService testService;
    @Autowired
    private MemberLoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public MyResult checkLogin(@RequestBody MemberLog log){
        MyResult result=new MyResult();
        if(loginService.login(log)){
            result.setMsg(VertificationCodeGenerator.getInstance().getVertificationCode());
            result.setObject(loginService.getKey(log.getEmail()));
            result.setCode(1);
            result.setList(null);
        }
        return result;
    }

}
