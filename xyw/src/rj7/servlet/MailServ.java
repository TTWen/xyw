package rj7.servlet;

import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		final String email = (String)request.getSession().getAttribute("txt_logemail");
		ApplicationContext actx = new ClassPathXmlApplicationContext(
				"rj7/mail/mailMessage.xml");
				JavaMailSender jms = (JavaMailSender)actx.getBean("mailSender");
				jms.send(new MimeMessagePreparator() {
					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true,"UTF-8");
						// 发送人,收件人,主题,内容
						mmh.setFrom("654819598@qq.com");
						mmh.setTo(email);
						mmh.setSubject("校游网-重置密码");
						mmh.setText("<html><head><meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>" +
						          "<meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=UTF-8'>" +
						          "</head><body>尊敬的用户：<br>您好！<br>您正在进行找回密码操作，请点击下面的链接修改密码:<br><a href='http://localhost:8080/xyw1/findpswd.jsp'>http://localhost:8080/xyw1/findpswd.jsp</a>" +
						          "<br><br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp校游网客户服务中心</body></html>", true);
					}
				});
				request.getRequestDispatcher("domail.jsp").forward(request, response);		
	}
	}
