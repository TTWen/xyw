package rj7.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Idle;
import rj7.bean.IdleFile;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;

@WebServlet("/IdleUpdateServ")
public class IdleUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public IdleUpdateServ() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method");
		String idleid = request.getParameter("idleid");
		String memid = request.getParameter("memid");
		
		List<Object> list = new ArrayList<Object>();//存放闲置物品信息的集合
		
		try
		{
			IdleDAOProxy proxy = new IdleDAOProxy();
			IdlefDAOProxy fproxy = new IdlefDAOProxy();
			if("updateidle".equals(method))
			{
				Idle idle = new Idle();
				
				idle.setIdleid(request.getParameter("idleid"));
				idle.setMemid(request.getParameter("memid"));
				idle.setIdlename(request.getParameter("idlename"));
				idle.setIdledetail(request.getParameter("idledetail"));
				idle.setIdletype(request.getParameter("idletype"));
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				idle.setIdletime(time);
				boolean b = new IdleDAOProxy().updateIdle(idle);
				if(b)
				{
					request.setAttribute("message","修改成功!浏览器将在3s后自动跳转到闲置物品展示页~~~如果没有跳转，请点击...<meta http-equiv='refresh' content='3;url=IdleServ?method=allidle'>" );
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
