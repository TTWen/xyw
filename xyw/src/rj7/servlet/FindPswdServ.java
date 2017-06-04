package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Member;
import rj7.util.Connect;
import rj7.util.DAO;
import rj7.util.DAOFactory;
/**
 * 找回密码
 */
public class FindPswdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String pswd = request.getParameter("pswd1");
		String email = (String)request.getSession().getAttribute("txt_logemail");
		
		DAO dao = DAOFactory.getDaoInstance();
		Member mem = (Member)dao.findById("tblmember", email, Member.class, "email");
		String id = mem.getId();
		if(dao.modigypswd("tblmember", pswd, id) == true){
			request.getRequestDispatcher("login.jsp").forward(request, response);		
		};
	}
	}
