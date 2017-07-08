package rj7.servlet;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;


@WebServlet("/IdleDeletefServ")
public class IdleDeletefServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public IdleDeletefServ() {
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
			IdlefDAOProxy fproxy = new IdlefDAOProxy();
			if("deleteidlef".equals(method))
			{//闲置物品某张图片的删除
				
				String idleid = request.getParameter("idleid");
				String memid = request.getParameter("memid");
				String idlefid = request.getParameter("idlefid");
				boolean b = fproxy.deleteIdlef(idlefid);
				
				if(b)
				{
					//response.sendRedirect("IdleServ?memid="+memid+"&idleid="+idleid+"method=detailidle");
					request.setAttribute("message","添加闲置物品成功!浏览器将在3s后自动跳转到该闲置物品详情页~~~如果没有跳转，请点击...<meta http-equiv='refresh' content='3;url=IdleServ?memid="+memid+"&idleid="+idleid+"&method=detailidle''>" );
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
