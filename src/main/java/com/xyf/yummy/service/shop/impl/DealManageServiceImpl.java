package com.xyf.yummy.service.shop.impl;

import com.xyf.yummy.dao.DealMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.dao.ProfitMapper;
import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.Profit;
import com.xyf.yummy.entity.sub.DealDish;
import com.xyf.yummy.entity.sub.DealPack;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.merchant.MerchantManageService;
import com.xyf.yummy.service.shop.DealManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.shop.impl
 */
@Service(value = "dealManageService")
public class DealManageServiceImpl implements DealManageService {
    private final double speed = 0.5;
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private ProfitMapper profitMapper;
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public List<Deal> getDeals() {
        return dealMapper.getDeals();
    }

    @Override
    public List<Deal> getMemberDeals(int mem_id) {
        return dealMapper.getDealsByMemberId(mem_id);
    }

    @Override
    public List<Deal> getMemberDeals(int mem_id, DealStateEnum state) {
        return dealMapper.getMemberDealsByState(mem_id,state);
    }

    @Override
    public List<Deal> getMerchantDeals(int mer_id) {
        return dealMapper.getDealsByMerchantId(mer_id);
    }

    @Override
    public List<Deal> getMerchantDeals(int mer_id, DealStateEnum state) {
        return dealMapper.getMerchantDealsByState(mer_id,state);
    }

    @Override
    public List<Deal> getTypeDeals(DealStateEnum state) {
        return dealMapper.getDealsByState(state);
    }

    @Override
    public boolean checkDistance(Address memberAddress, int merchantId, int time) {
        Address address = merchantMapper.selectByPrimaryKey(merchantId).getAddress();
        double d_x = address.getLongitude()-memberAddress.getLongitude();
        double d_y = address.getLatitude()-memberAddress.getLatitude();
        double distance = Math.sqrt(d_x*d_x+d_y*d_y);
        return time-distance/speed>0;
    }

    @Override
    public boolean generateDeal(Deal deal) {
        boolean sign = dealMapper.insertSelective(deal)>0;

        if(sign){
            int dealId = deal.getId();
            for(DealDish dish: deal.getDishes()) dealMapper.insertDishInDeal(dealId,dish.getDish().getId(),dish.getNum());
            for (DealPack pack: deal.getPacks()) dealMapper.insertPackInDeal(dealId,pack.getPack().getId(),pack.getNum());
            Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    DealStateEnum stateEnum = dealMapper.selectByPrimaryKey(dealId).getState();
                    System.out.println(stateEnum.getName());
                    if(stateEnum.equals(DealStateEnum.SET_UP)){
                        cancelDeal(dealId);
                        System.out.println("cancel");
                    }

                }
            }, 1000 * 60);
        }
        return sign;
    }

    @Override
    public boolean cancelDeal(int id) {
        return dealMapper.changeState(id,DealStateEnum.CANCELLED)==1;
    }

    @Override
    public boolean payDeal(int id) {
        return dealMapper.changeState(id,DealStateEnum.ACCOUNT_PAID)==1;
    }

    @Override
    public boolean refundDeal(int id) {
        Deal deal = dealMapper.selectByPrimaryKey(id);
        deal.setRefund(deal.getFinalPrice()/2);
        deal.setState(DealStateEnum.REFUNDED);
        return dealMapper.updateByPrimaryKeySelective(deal)>0;
    }

    @Override
    public boolean completeDeal(int id) {
        double profit = profitMapper.getCurrentProfit().getRatio();
        Deal deal = dealMapper.selectByPrimaryKey(id);
        deal.setProfit(deal.getFinalPrice()*profit/100);
        deal.setActualBenefit(deal.getFinalPrice()*(1-profit/100));
        deal.setState(DealStateEnum.RECEIVED);
        return dealMapper.updateByPrimaryKeySelective(deal)>0;
    }
}
