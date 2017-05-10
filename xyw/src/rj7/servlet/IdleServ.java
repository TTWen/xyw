package rj7.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Idle;
import rj7.dao.idle.IdleDAOProxy;

/**
 * @name 闲置物品的servlet 目前包括以下方法：
 * 		   查找所有用户全部闲置物品/按照用户id查找其全部闲置物品/添加一个闲置物品/删除一个闲置物品/更新一个闲置物品信息
 * @author TTWen 2017.5.5
 * @note：数据库的时间类型是datetime，可以存，但取出就是date类型（暂时还没改好
 */

//@WebServlet("/IdleServ")
public class IdleServ extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		List<Object> list = new ArrayList<Object>();
	
		try
		{
			IdleDAOProxy proxy = new IdleDAOProxy();
			//method = allidle 查找全部方法
			if("allidle".equals(method))
			{
				list = proxy.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/showallidle.jsp").forward(request, response);
			}
			//method = findbyuser 按照用户id查找该用户的所有闲置物品
			if("findbyuser".equals(method))
			{
				String memid = request.getParameter("memid");
				proxy = new IdleDAOProxy();
				list = proxy.findByUser(memid);
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("/showallidle.jsp").forward(request, response);
			}
			//method = addidle 添加一个闲置物品
			if("addidle".equals(method))
			{
				String memid = request.getParameter("memid");
				Idle idle = new Idle();
				
				//idle.setIdleid(request.getParameter("idleid"));//看情况
				idle.setMemid(request.getParameter("memid"));
				idle.setIdlename(request.getParameter("idlename"));
				idle.setIdledetail(request.getParameter("idledetail"));
				idle.setIdlepicurl(request.getParameter("idlepicurl"));
				idle.setIdletype(request.getParameter("idletype"));
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				idle.setIdletime(time);

				boolean b = new IdleDAOProxy().addIdle(idle);
				if(b)
				{
					request.setAttribute("message","添加闲置物品成功!浏览器将在3s后自动跳转到闲置物品展示页~~~如果没有跳转，请点击...<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/servlet/IdleServ?method=allidle'>" );
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}
			}
			//method = deleteidle 删除一个闲置物品
			if("deleteidle".equals(method))
			{
				String idleid = request.getParameter("idleid");
				proxy = new IdleDAOProxy();
				boolean b = proxy.deleteIdle(idleid);
				if(b)
				{
					response.sendRedirect(request.getContextPath()+"/servlet/IdleServ?method=allidle");
				}
			}
			//method = updateidle 更新修改一个闲置物品
			if("updateidle".equals(method))
			{
				Idle idle = new Idle();
				
				idle.setIdleid(request.getParameter("idleid"));
				idle.setMemid(request.getParameter("memid"));
				idle.setIdlename(request.getParameter("idlename"));
				idle.setIdledetail(request.getParameter("idledetail"));
				idle.setIdlepicurl(request.getParameter("idlepicurl"));
				idle.setIdletype(request.getParameter("idletype"));
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				idle.setIdletime(time);
				boolean b = new IdleDAOProxy().updateIdle(idle);
				if(b)
				{
					request.setAttribute("message","修改成功!浏览器将在3s后自动跳转到闲置物品展示页~~~如果没有跳转，请点击...<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/servlet/IdleServ?method=allidle'>" );
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}