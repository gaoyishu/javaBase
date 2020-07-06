package com.gys;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailDemo01 {
//一封简单的邮件
public static void main(String[] args){

    Properties properties = new Properties();
    properties.setProperty("mail.host","smtp.163.com"); //设置主机是哪个邮件服务器
    properties.setProperty("mail.transport.protocol","smtp");//设置协议的protocol
    properties.setProperty("mail.smtp.auth","true");//设置邮件的认证

    //使用java发送的五个步骤
    //1 创建session对象 + 权限处理

    Session session = Session.getDefaultInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            //下面的第一个参数为你163邮箱账户，第二个是申请pop3和smtp发给你的权限密码
            return new PasswordAuthentication("邮箱账户","权限密码");
        }
    });

    //2 通过session，得到transport对象
    try {
        Transport ts = session.getTransport();
        //3 通过ts 的 connection 连接服务器
        ts.connect("smtp.163.com","gaoyishu91@163.com","KLXOVHQGUKHUIYDD");
        // 4 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress("gaoyishu91@163.com"));
        //设置收件人
        message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("gaoyishu91@163.com")));
        //设置标题
        message.setSubject("第一封邮件");
        //设置内容
        message.setContent("你好","text/html;charset=UTF-8");
        //transport 发送
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();
    } catch (MessagingException e) {
        e.printStackTrace();
    }

}
}
