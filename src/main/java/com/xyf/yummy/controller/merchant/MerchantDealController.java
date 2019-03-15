package com.xyf.yummy.controller.merchant;

import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.admin.MerchantDataGatherService;
import com.xyf.yummy.service.shop.DealManageService;
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
@RequestMapping("/yummy/merchant/{mer_id}/deals")
public class MerchantDealController {
    @Autowired
    private DealManageService dealManageService;
//    @Autowired
//    private MerchantDataGatherService merchantDataGatherService;

    @GetMapping("")
    public ModelBean getDeals(@PathVariable String mer_id,
                              @RequestParam(value = "type", required = false) String type){
        int merchantId = Integer.parseInt(mer_id);
        if(type==null)
            return new ModelBean(1,"", null, dealManageService.getMerchantDeals(merchantId));
        else{
            DealStateEnum state = DealStateEnum.getJsonEnum(type) ;
            return new ModelBean(1,"",null,dealManageService.getMerchantDeals(merchantId,state));
        }
    }


}
