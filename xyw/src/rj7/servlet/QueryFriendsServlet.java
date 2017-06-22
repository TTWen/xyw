package rj7.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Attention;
import rj7.bean.Member;
import rj7.dao.attention.IAttentionDAO;
import rj7.dao.queryuser.IQueryDAO;
import rj7.util.DAO;
import rj7.util.DAOFactory;

@WebServlet("/QueryFriendsServlet")
/**
 * Servlet implementation class QueryFriendsServlet
 */
public class QueryFriendsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Member mem = new Member();
		String username = request.getParameter("key");
		int age1, age2;
		String dowhat = request.getParameter("dowhat");

		if("indexQuery".equals(dowhat)) {
			String criteria = "where username like '%" + username +"%'";
			DAO dao = new DAO();
			List<Object> li = dao.pageQuery("tbluser", Member.class, 0, 10, criteria);
			request.setAttribute("user", li);
			request.getRequestDispatcher("ShowFriendsList.jsp").forward(request, response);
			
		} else {
			if(request.getParameter("key")!="")
			{
				mem.setUsername(username);
			}
			 String sex = request.getParameter("sex");
			 if("1".equals(sex)){
				sex = "男";
			 } else if("0".equals(sex)){
				sex = "女";
			 } else {
				sex = "";
			 }
			 if(sex != "")
			 {
			 	mem.setSex(sex);
			 }
			 String city = request.getParameter("city");
			 if(city != "")
			{
				mem.setCity(city);
			}
			if(request.getParameter("age1") != "")
			{
				age1 = Integer.valueOf(request.getParameter("age1"));	
			}
			else{
				age1 = 0;
			}
			if(request.getParameter("age2") != "")
			{
				age2 = Integer.valueOf(request.getParameter("age2"));	
			}
			else{
				age2 = 100;
			}
			ArrayList<Member> user=new ArrayList<Member>();
			
			try{
				user = DAOFactory.getIQueryDAOInstance().queryUser(mem,age1,age2); 
				request.setAttribute("user", user);
				request.getRequestDispatcher("ShowFriendsList.jsp").forward(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
			
		}
		
	}

}
