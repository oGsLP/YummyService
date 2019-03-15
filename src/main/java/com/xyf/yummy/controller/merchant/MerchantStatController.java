package com.xyf.yummy.controller.merchant;

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
 * @Package: com.xyf.yummy.controller.merchant
 */
@RestController
@RequestMapping("/yummy/merchant/{mer_id}/stat")
public class MerchantStatController {

    @GetMapping("")
    public ModelBean getStat(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);



        return new ModelBean();
    }
}
