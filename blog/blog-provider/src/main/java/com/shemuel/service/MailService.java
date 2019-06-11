package com.shemuel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class MailService {
    @Value("${spring.mail.username}")
    private String from;
    private JavaMailSender jms ;
    // 有参构造,spring 会将参数自动注入 AutoWired可以省略

    public MailService(@Autowired JavaMailSender jms) {
        this.jms = jms;
    }
    public void sendMail (String exceptionMsg) throws Exception{
        MimeMessage mimeMessage = jms.createMimeMessage();
        mimeMessage.setContent("<h1>主人,你的服务器发生异常了!</h1>异常信息:" + exceptionMsg,"text/html;charset=utf-8");
        mimeMessage.setSubject("服务器异常通知");
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("1241916209@qq.com"));
        mimeMessage.setFrom(this.from);
        mimeMessage.setSentDate(new Date());
        mimeMessage.setDescription("this is description");
        jms.send(mimeMessage);
    }
}
