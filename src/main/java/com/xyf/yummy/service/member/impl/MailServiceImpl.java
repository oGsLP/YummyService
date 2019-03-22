package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.service.member.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/20
 * @Time: 22:38
 * @Package: com.xyf.yummy.service.member.impl
 */
@Service(value = "mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    //邮件发件人
    @Value("${mail.fromMail.addr}")
    private String from;
    @Override
    public void sendCode(String email, String code) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email); // 发送给谁
        mail.setSubject("Verify Code"); // 标题
        mail.setFrom(from); // 来自
        // 邮件内容
        mail.setText(code);

        System.out.println(from);
        System.out.println(email+code);
        mailSender.send(mail); // 发送
    }
}
