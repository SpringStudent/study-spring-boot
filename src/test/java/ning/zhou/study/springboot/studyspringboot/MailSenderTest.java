package ning.zhou.study.springboot.studyspringboot;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周宁
 * @Date 2019-05-17 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSenderTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void sendSimpleEmail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("18356070692@163.com");
        mailMessage.setTo("2267431887@qq.com");
        mailMessage.setSubject("测试");
        mailMessage.setText("你好烦");
        javaMailSender.send(mailMessage);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("18356070692@163.com");
        helper.setTo("2267431887@qq.com");
        helper.setSubject("测试发送附件");
        helper.setText("你好烦");

        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\工作\\我的图片\\port.jpg"));
        helper.addAttachment("头像.jpg",fileSystemResource);
        helper.addAttachment("头像2.jpg",fileSystemResource);
        javaMailSender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("18356070692@163.com");
        helper.setTo("2267431887@qq.com");
        helper.setSubject("测试静态资源");
        helper.setText("<html><body><img src=\"cid:touxiang\"></body></html>",true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\工作\\我的图片\\port.jpg"));
        helper.addInline("touxiang",fileSystemResource);
        javaMailSender.send(mimeMessage);
    }

    @Test
    public void sendTempalteMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("18356070692@163.com");
        helper.setTo("2267431887@qq.com");
        helper.setSubject("模板邮件");
        Map<String,Object> model = new HashMap<>();
        model.put("username","大宁");
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,"/templates/template.vm","UTF-8",model);

        helper.setText(text);

        javaMailSender.send(mimeMessage);
    }
}
