package top.mcwebsite.mailinaction.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring5.expression.ThymeleafEvaluationContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.file.FileSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 发送简单的文本
     */
    @Test
    public void sendSimpleMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo("sunxiaozhe007@163.com");
        mailMessage.setSubject("主题：简单邮件");
        mailMessage.setText("测试邮件内容");
        mailSender.send(mailMessage);
    }

    /**
     * 发送Html邮件
     */
    @Test
    public void sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(sender);
            helper.setSubject("标题：发送Html内容");
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题</h1>")
                    .append("<p style='color: #F00'>啦啦啦啦啦啦啦</p>")
                    .append("<p style='text-align: right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    /**
     * 带有附件的邮件
     */
    @Test
    public void sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(sender);
            helper.setSubject("主题：带有附件的邮件");
            helper.setText("附件里面有张图片");
            FileSystemResource file = new FileSystemResource("E:\\project\\Java Study\\Spring\\Spring Boot\\mail-in-action\\src\\main\\resources\\static\\image.jpg");
            helper.addAttachment("图片.jpg", file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;
    /**
     * 发送模版邮件
     */
//    @Test
//    public void sendTemplateMail() {
//        thymeleafViewResolver.
//    }

}
