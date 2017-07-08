package rj7.servlet;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Idle;
import rj7.bean.IdleFile;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;


@WebServlet("/IdleDetailServ")
public class IdleDetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IdleDetailServ() {
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
			if("detailidle".equals(method))
			{
				String idleid = request.getParameter("idleid");
				Object obj = proxy.findById(idleid);//根据闲置物品ID获取闲置物品实体
				Idle idle = (Idle) obj;
				if(obj!=null)
				{
					proxy = new IdleDAOProxy();
					List flist= fproxy.findByIdle(idleid);//根据闲置物品ID获取对应图片集合
					
					request.setAttribute("flist", flist);
					request.setAttribute("idle", idle);
					request.getRequestDispatcher("/idledetail.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
