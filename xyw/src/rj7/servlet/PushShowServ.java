package rj7.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;
import rj7.util.DAO;


public class PushShowServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pagenum = 0;//保存当前页数
    public PushShowServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 int pageindex;
		 //页面跳转pageindex!=null
		 //增删改后返回，pageindex=null
		 if(request.getParameter("pageindex")!=null){
			 pageindex = Integer.parseInt(request.getParameter("pageindex")) ;
			 this.pagenum = pageindex;
		 } else{
			 pageindex = pagenum;
		 }
		int pagenum = 10;
		request.setAttribute("curpagenum", pageindex);
		DAO dao = new DAO();
		List<Object> push = dao.pageQuery("tblpush", Push.class, pageindex, pagenum, null);
		PushDAOProxy pro = new PushDAOProxy();
		int count = 0;
		try {
			count = pro.findAll().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count%pagenum==0){
			request.setAttribute("pagecount", count/pagenum-1);
		} else{
			request.setAttribute("pagecount", count/pagenum);
		}
		request.setAttribute("pnum", pageindex);
		request.setAttribute("pageMember", push);
		request.getRequestDispatcher("pushmanage.jsp").forward(request, response);
		return;
	}
	

}
