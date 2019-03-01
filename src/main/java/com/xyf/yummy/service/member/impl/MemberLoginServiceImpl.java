package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.MemberLog;
import com.xyf.yummy.model.enums.MemValEnum;
import com.xyf.yummy.service.member.MemberLoginService;
import com.xyf.yummy.util.PasswordEncryption;
import com.xyf.yummy.util.UUIDGenerator;
import com.xyf.yummy.util.VertificationCodeGenerator;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:37
 * @Package: com.xyf.yummy.service.member.impl
 */

@Service(value = "memberLoginService")
public class MemberLoginServiceImpl implements MemberLoginService {
    private PasswordEncryption encryption = PasswordEncryption.getEncryption();
    private UUIDGenerator uuidGenerator = UUIDGenerator.getInstance();
    private VertificationCodeGenerator codeGenerator = VertificationCodeGenerator.getInstance();
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public boolean register(MemberLog log) {
        String email=log.getEmail();
        String password=log.getPassword();
        MemValEnum valEnum=memberMapper.checkAccount(email);
        if(valEnum!=null)
            return false;
        else {
            Member member=new Member();
            member.setEmail(email);member.setPassword(encryption.encrypt_md5_16bits(password));
            member.setName("User"+uuidGenerator.getUUID_str_16bits());
            memberMapper.insertSelective(member);
            return true;
        }
    }

    @Override
    public String getKey(String email) {
        String code=codeGenerator.getVertificationCode();
        codeGenerator.sendCode(email,code);
        return code;
    }


    @Override
    public boolean login(MemberLog log) {
        String name=memberMapper.checkLogin(log.getEmail(),encryption.encrypt_md5_16bits(log.getPassword()));
        return name != null;
    }

    @Override
    public void cancelAccount(String email) {
        if(memberMapper.getIdByEmail(email) == null) {
            memberMapper.cancelAccount(memberMapper.getIdByEmail(email),MemValEnum.CANCELLED);
        }
    }
}
