<%@ page import="javax.mail.*, java.util.*, javax.mail.internet.*, java.io.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Properties props = new Properties();
	props.put("mail.host","219.216.128.8");
	Session ses = Session.getDefaultInstance(props,null);
	MimeMessage msg = new MimeMessage(ses);
	InternetAddress from = new InternetAddress("mail.dns.com.cn");
	InternetAddress to = new InternetAddress("654819598@qq.com");
	msg.setFrom(from);
	msg.addRecipient(Message.RecipientType.TO,to);
	msg.setSubject("重置密码");
	String source = application.getRealPath("")+"\\"+"findpswd.html";
	String content = "";
	String line = null;
	BufferedReader br = new BufferedReader(new FileReader(source));
	while((line = br.readLine()) != null){
	content += line;		
	}
	br.close();
	msg.setContent(content,"text/html");
	Transport tran = ses.getTransport("smtp");
	tran.connect("219.216.128.8","mail.dns.com.cn","password");
	tran.send(msg);
	out.println("邮件发送成功,请注意查收");
%>
</body>
</html>