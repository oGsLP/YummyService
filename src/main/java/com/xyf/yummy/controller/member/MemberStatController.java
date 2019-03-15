package com.xyf.yummy.controller.member;

import com.xyf.yummy.model.ModelBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("")
    public ModelBean getStat(@PathVariable String mem_id){
        int memberId = Integer.parseInt(mem_id);



        return new ModelBean();
    }
}
