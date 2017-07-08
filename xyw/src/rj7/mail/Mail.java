package rj7.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Mail {
	
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext(
		"rj7/mail/mailMessage.xml");
		JavaMailSender jms = (JavaMailSender)actx.getBean("mailSender");
		jms.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true,"UTF-8");
				// 发送人,收件人,主题,内容
				mmh.setFrom("654819598@qq.com");
				mmh.setTo("914135112@qq.com");
				mmh.setSubject("校游网-重置密码");
				mmh.setText("<html><head><meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>" +
				          "<meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=UTF-8'>" +
				          "</head><body>尊敬的用户：<br>您好！<br>您正在进行找回密码操作，请点击下面的链接修改密码:<br><a href='http://localhost:8080/xyw1/findpswd.jsp'>http://localhost:8080/xyw1/findpswd.jsp</a>" +
				          "<br><br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp校游网客户服务中心</body></html>", true);
			}
		});
	}
}

