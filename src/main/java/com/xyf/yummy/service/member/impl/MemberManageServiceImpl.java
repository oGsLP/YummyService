package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.dao.AddressMapper;
import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.MemberInfo;
import com.xyf.yummy.service.member.MemberManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.member.impl
 */
@Service(value = "memberManageService")
public class MemberManageServiceImpl implements MemberManageService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public MemberInfo getInfo(int id) {
        MemberInfo info = null;
        Member member = memberMapper.selectByPrimaryKey(id);
        if(member!=null){
            info = new MemberInfo(member);
        }
        return info;
    }

    @Override
    public void modifyInfo(MemberInfo info) {
        memberMapper.updateByPrimaryKeySelective(setBackInfo(info));
    }

    @Override
    public boolean addAddress(Address address) {
        return addressMapper.insertSelective(address)==1;
    }

    @Override
    public boolean addAddress(int mem_id,Address address) {
        addressMapper.insertSelective(address);
        return addressMapper.addMemberAddress(mem_id, address.getId()) == 1;
    }

    @Override
    public boolean deleteAddress(int id) {
        return addressMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean deleteAddress(int mem_id, int id) {
        int sign = addressMapper.deleteMemberAddress(mem_id, id);
        if(sign==1){
            sign=addressMapper.deleteByPrimaryKey(id);
            return sign == 1;
        }
        return false;
    }

    @Override
    public boolean modifyAddress(Address address) {
        return addressMapper.updateByPrimaryKey(address)==1;
    }

    private Member setBackInfo(MemberInfo info){
        Member member = new Member();
        member.setId(info.getId());
        member.setName(info.getName());
        member.setEmail(info.getEmail());
        member.setPhone(info.getPhone());
        return member;
    }
}
