package rj7.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rj7.bean.Attention;
import rj7.bean.Member;
import rj7.dao.attention.IAttentionDAO;
import rj7.util.DAOFactory;
@WebServlet("/AttenFriendsServlet")
/**
 * 关注好友Servlet
 * @author 娄梦慧
 *
 */
public class AttenFriendsServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String dowhat = request.getParameter("dowhat");
		
		//根据前台页面dowhat的值判断执行业务
		if("Attention".equals(dowhat)){
			atten(request,response);  //关注好友
		}
		else if("UnAttention".equals(dowhat)){
			unAtten(request,response);
		}
		else if("MyAtten".equals(dowhat)){
			MyAtten(request,response);
		}
		else if("MyFans".equals(dowhat)){
			MyFans(request,response);
		}
	}
	//我的粉丝
	private void MyFans(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userid = session.getAttribute("crtuid").toString();   //用户id
		 ArrayList<Object> mem= new ArrayList<Object>();
		 try{
			 IAttentionDAO dao = DAOFactory.getIAttentionDAOInstance();
			 mem = dao.hasBeenAtten(userid);
			 request.setAttribute("mem", mem);
			 request.getRequestDispatcher("ShowFansList.jsp").forward(request, response);
		 }  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
	}
	//我的关注
	private void MyAtten(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userid = session.getAttribute("crtuid").toString();   //用户id
		 ArrayList<Object> mem= new ArrayList<Object>();
		 try{
			 IAttentionDAO dao = DAOFactory.getIAttentionDAOInstance();
			 mem = dao.hasAtten(userid);
			 request.setAttribute("mem", mem);
			 request.getRequestDispatcher("ShowAttenList.jsp").forward(request, response);
		 }  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
	}
	//关注好友
	private void atten(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = session.getAttribute("crtuid").toString();  //关注人id
		String attenid=request.getParameter("attenid");
		System.out.println("hhh");
		Attention atten = new Attention();
		atten.setUserid(userid);
		atten.setAttenid(attenid);
		try {
			
			IAttentionDAO dao = DAOFactory.getIAttentionDAOInstance();
			if(dao.AttentionUser(atten) )
			{  
				request.getRequestDispatcher("ShowFriendsList.jsp").forward(request, response);  //关注成功，返回当前页面
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		//取消关注好友
		private void unAtten(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			String userid = session.getAttribute("crtuid").toString();
			System.out.println("userid");
			String attenid=request.getParameter("attenid");
			System.out.println("attenid");
			Attention atten = new Attention();
			atten.setUserid(userid);
			atten.setAttenid(attenid);
			try {
				IAttentionDAO dao = DAOFactory.getIAttentionDAOInstance();
				if(dao.UnAttentionUser(atten))
				{
					System.out.println("chnegg");
					request.getRequestDispatcher("ShowFriendsList.jsp").forward(request, response);  //关注成功，返回当前页面
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
