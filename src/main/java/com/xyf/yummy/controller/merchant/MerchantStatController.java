package com.xyf.yummy.controller.merchant;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.MerchantDiscount;
import com.xyf.yummy.model.MerchantStat;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.service.admin.MerchantDataGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private MerchantDataGatherService dataGatherService;

    @GetMapping("")
    public ModelBean getStat(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        MerchantStat stat = new MerchantStat();
        stat.setComplete(dataGatherService.getComplete(merchantId));
        stat.setRefund(dataGatherService.getRefund(merchantId));
        stat.setTotal(dataGatherService.getTotal(merchantId));
        List<Member> members = dataGatherService.getMostUsually(merchantId);

        return new ModelBean(1,"",stat,members);
    }

    @GetMapping("/discounts")
    public ModelBean getDiscount(@PathVariable String mer_id){
        int merchantId = Integer.parseInt(mer_id);
        MerchantDiscount discount = dataGatherService.getDiscount(merchantId);
        return new ModelBean(1,"",discount);
    }

    @PutMapping("/discounts")
    public ModelBean putDiscount(@RequestBody MerchantDiscount discount){
        dataGatherService.setDiscount(discount);
        return new ModelBean(1,"");
    }
}
