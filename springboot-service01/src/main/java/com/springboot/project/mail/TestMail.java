package com.springboot.project.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * 测试发送163邮件的类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {

    private static final Logger log= LoggerFactory.getLogger(TestMail.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    //测试发送一个简单的文本
    @Test
    public void sendSimpleText(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(new String[] {"marryfeng9998@163.com"});
        message.setFrom("marryfeng9998@163.com");
        message.setSubject("个人资料");
        message.setText("个人信息");

        mailSender.send(message);
       log.info("邮件已经发送");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo("marryfeng9998@163.com");
        mimeMessageHelper.setFrom("marryfeng9998@163.com");
        mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);
        // 发送邮件
        mailSender.send(mimeMessage);

        System.out.println("邮件已发送");

    }

    /**
     * 发送包含内嵌图片的邮件
     * @throws Exception
     */
    @Test
    public void sendAttachedImageMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // multipart模式
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo("marryfeng9998@163.com");
        mimeMessageHelper.setFrom("marryfeng9998@163.com");
        mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【图片】");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
        // cid为固定写法，imageId指定一个标识
        sb.append("<img src=\"cid:imageId\"/></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);

        // 设置imageId
        FileSystemResource img = new FileSystemResource(new File("E:/1.jpg"));
        mimeMessageHelper.addInline("imageId", img);

        // 发送邮件
        mailSender.send(mimeMessage);

        System.out.println("邮件已发送");
    }

    /**
     * 发送包含附件的邮件
     * @throws Exception
     */
    @Test
    public void sendAttendedFileMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // multipart模式
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        mimeMessageHelper.setTo("marryfeng9998@163.com");
        mimeMessageHelper.setFrom("marryfeng9998@163.com");
        mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【附件】");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);
        // 设置附件
        FileSystemResource img = new FileSystemResource(new File("E:/1.jpg"));
        mimeMessageHelper.addAttachment("image.jpg", img);

        // 发送邮件
        mailSender.send(mimeMessage);

        System.out.println("邮件已发送");
    }
}
