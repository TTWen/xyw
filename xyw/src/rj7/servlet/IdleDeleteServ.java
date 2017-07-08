package rj7.servlet;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Idle;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;

@WebServlet("/IdleDeleteServ")
public class IdleDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public IdleDeleteServ() {
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
			if("deleteidle".equals(method))
			{//这里同时也要把该闲置物品的所有图片删除
				
				String idleid = request.getParameter("idleid");
				boolean b1 = proxy.deleteIdle(idleid);
				boolean b2 = fproxy.deleteIdlefs(idleid);
				if(b1 && b2)
				{
					response.sendRedirect("IdleServ?method=allidle");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
