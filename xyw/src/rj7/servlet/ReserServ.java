package rj7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Reserve;
import rj7.dao.reserve.ReserDAOProxy;

@WebServlet("/ReserServ")
public class ReserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReserServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String method=(String)request.getParameter("method");
		response.setContentType("text/html");		
		response.setCharacterEncoding("utf-8");
		
		try {
			if("reseradd".equals(method)){
				this.doadd(request, response);
				}
			 else if("reserdelete".equals(method)){
				this.dodelete(request, response);
			} else{
				this.dosearch(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	private void doadd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				
				//预约代理类
				ReserDAOProxy rp = new ReserDAOProxy();
				//预约对象
				Reserve rs = new Reserve();
				//将获取的页面信息封装到javabean
				rs.setReserid(request.getParameter("reserid"));
				rs.setReuserid(request.getParameter("reuserid"));
				rs.setReduserid(request.getParameter("reduserid"));
				rs.setReserbegtime(request.getParameter("rebegtime"));
				rs.setResercity(request.getParameter("resercity"));
//				rs.setReuserid("1");
//				rs.setReduserid("1");
//				rs.setReserbegtime("1");
//				rs.setResercity("1");
				//调用代理类方法进行添加
				if(rp.doCreate(rs)){
					request.setAttribute("reback","添加成功");
				} else{
					request.setAttribute("reback","添加失败");
				}
				request.getRequestDispatcher("initireser.jsp").forward(request, response);
				return;
	}
	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
