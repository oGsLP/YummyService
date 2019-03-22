package com.xyf.yummy.service.merchant.impl;

import com.xyf.yummy.dao.AddressMapper;
import com.xyf.yummy.dao.MerchantDiscountMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.MerchantDiscount;
import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.model.enums.MerchantVerEnum;
import com.xyf.yummy.service.merchant.MerchantManageService;
import com.xyf.yummy.util.CDKeyGenerator;
import com.xyf.yummy.util.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:25
 * @Package: com.xyf.yummy.service.merchant.impl
 */
@Service(value = "merchantManageService")
public class MerchantManageServiceImpl implements MerchantManageService {

    private CDKeyGenerator generator = CDKeyGenerator.getInstance();
    private PasswordEncryption encryption = PasswordEncryption.getEncryption();

    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private MerchantDiscountMapper discountMapper;

    @Override
    public String apply() {
        return generator.generate();
    }

    @Override
    public boolean register(String cdkey, String password) {
        if(merchantMapper.getMerchantByCdkey(cdkey)!=null)
            return false;
        else {
            Merchant merchant = new Merchant();
            merchant.setCdkey(cdkey);merchant.setPassword(encryption.encrypt_md5_16bits(password));
            merchant.setName("Merchant"+cdkey.substring(3));
            boolean sign = merchantMapper.insertSelective(merchant)==1;
            MerchantDiscount discount = new MerchantDiscount();
            discount.setMerId(merchant.getId());
            discount.setMin(35);
            discount.setDiscount(5);
            sign = sign&discountMapper.insertSelective(discount)==1;
            return sign;
        }
    }

    @Override
    public Merchant login(String cdkey, String password) {
        return merchantMapper.checkLogin(cdkey,encryption.encrypt_md5_16bits(password));
    }

    @Override
    public boolean submitInfo(int mer_id, MerchantInfo info) {
        Address address = info.getAddress();
        address.setId(null);
        addressMapper.insertSelective(address);
        Merchant merchant = merchantMapper.selectByPrimaryKey(mer_id);
        merchant.setAdId(address.getId());
        merchant.setType(info.getType());
        merchant.setName(info.getName());
        merchant.setVertification(MerchantVerEnum.BEFORE_APPROVAL);
        return merchantMapper.updateByPrimaryKeySelective(merchant)==1;
    }
    //// address 的 insert 问题

    @Override
    public MerchantInfo getInfo(int mer_id) {
        Merchant merchant = merchantMapper.selectByPrimaryKey(mer_id);
        return setBackMerchantInfo(merchant);
    }

    private MerchantInfo setBackMerchantInfo(Merchant merchant){
        MerchantInfo info = new MerchantInfo();
        info.setName(merchant.getName());
        info.setType(merchant.getType());
        info.setAddress(merchant.getAddress());
        info.setVerEnum(merchant.getVertification());
        return info;
    }
}
