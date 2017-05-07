package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Attention;
import rj7.dao.attention.IAttentionDAO;
import rj7.util.DAOFactory;
import sun.swing.SwingUtilities2.Section;
/**
 * 关注好友Servlet
 * @author 娄梦慧
 *
 */
public class AttenFriendsServlet extends HttpServlet {	
	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
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
	}
	
	//关注好友
	private void atten(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");   //关注人id
		String attenid = request.getParameter("attenid");  //被关注人id
		Attention atten = new Attention();
		atten.setUserid(userid);
		atten.setAttenid(attenid);
		try {
			IAttentionDAO dao = DAOFactory.getIAttentionDAO();
			if(dao.AttentionUser(atten) )
			{
				request.getRequestDispatcher("AttenFriends.jsp").forward(request, response);  //关注成功，返回当前页面
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
