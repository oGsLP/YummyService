package com.xyf.yummy.controller.merchant;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.merchant.MerchantManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/11
 * @Time: 14:28
 * @Package: com.xyf.yummy.controller.merchant
 */
@RestController
@RequestMapping("/yummy/merchant/{mer_id}/info")
public class MerchantInfoController {

    @Autowired
    private MerchantManageService manageService;

    @GetMapping("")
    public ModelBean getInfo(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        MerchantInfo info = manageService.getInfo(merchantId);
        return new ModelBean(1,"",info);
    }

    @PostMapping("")
    public ModelBean modifyInfo(@PathVariable String mer_id, @RequestBody MerchantInfo info){
        int merchantId = Integer.parseInt(mer_id);
        int sign = manageService.submitInfo(merchantId,info)?1:0;
        return new ModelBean(sign, sign==1?"Modify Success!":"Modify failed!");
    }

}
