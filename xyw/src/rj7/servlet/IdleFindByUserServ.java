package rj7.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class IdleFindByUserServ
 */
@WebServlet("/IdleFindByUserServ")
public class IdleFindByUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IdleFindByUserServ() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		List<Object> list = new ArrayList<Object>();//存放闲置物品信息的集合
		
		try
		{
			IdleDAOProxy proxy = new IdleDAOProxy();
			IdlefDAOProxy fproxy = new IdlefDAOProxy();
			if("findbyuser".equals(method))
			{
				String memid = request.getParameter("memid");
				proxy = new IdleDAOProxy();
				list = proxy.findByUser(memid);
				
				request.setAttribute("memid", memid);
				request.setAttribute("list", list);
				request.setAttribute("map", "map");
				request.setAttribute("idlecount", list.size());
				request.getRequestDispatcher("/showallidle.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
