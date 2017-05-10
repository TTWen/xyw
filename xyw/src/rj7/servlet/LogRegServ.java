package rj7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Member;
import rj7.util.DAO;
import rj7.util.DAOFactory;

@WebServlet("/LogRegServ")
/**
 * 用户及管理员登录注册servlet
 * @author 梁爽爽  2017.4.22
 *
 */
public class LogRegServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogRegServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dowhat = request.getParameter("dowhat");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 获取DAO实例
		DAO dao = DAOFactory.getDaoInstance();
		
		// 获取账号密码
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		System.out.println(pswd);
		// 登录
		if("log".equals(dowhat)){
			
			// 登录成功后跳转
			if(dao.login(username, pswd, "tblUser")!= 0) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			// 登录失败
			} else {
				response.sendRedirect("login.jsp?error=logfail");
			}
			
		// 注册
		} else if("reg".equals(dowhat)){
			
			String email = request.getParameter("email");
			
			// 查找用户名是否重复
			if(dao.findById("tblUser", username, Member.class, "username") != null){
				response.sendRedirect("regist.jsp?error=reusername");
				
			// 注册成功后跳转到登录页面
			} else if(dao.regist(username, pswd, "tblUser", email) != 0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			// 注册失败
			} else {
				response.sendRedirect("regist.jsp?error=regfail");
			}
		}
	}

}
