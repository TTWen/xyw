package rj7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dowhat = request.getParameter("dowhat");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 登录
		if("log".equals(dowhat)){
			// 获取账号密码
			String username = request.getParameter("username");
			String pswd = request.getParameter("pswd");
			
			// 登录成功后跳转
			if(DAOFactory.getDaoInstance().login(username, pswd, "tblUser")!= 0) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} 
		}
	}

}
