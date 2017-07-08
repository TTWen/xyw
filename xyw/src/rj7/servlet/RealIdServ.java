package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Real;
import rj7.dao.real.RealDAOProxy;
@WebServlet("/RealIdServ")
/**
 * 对于身份认证的处理servlet
 * @author 史国梅  2017.5.8
 *
 */
//${pageContext.request.contextPath}/servlet/
public class RealIdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			idreal(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//插入实名认证信息
	private void idreal(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
//      获取表单数据		
		response.setContentType("text/html");		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		//		参数
		String userid=(String)request.getSession().getAttribute("crtuid");
		System.out.println("yonghu "+userid);
		String adress=request.getParameter("adress");
		String idcard=request.getParameter("idcard");
		String name=request.getParameter("name");
//		String rid=request.getParameter("rid");		
		String post=request.getParameter("post");
		System.out.print("dizhi "+adress);
//		给表字段赋值
		Real real=new Real();
//		real.setRid(rid);
		real.setAdress(adress);
		real.setIdcard(idcard);
		real.setName(name);
		real.setPost(post);
		real.setUserid(userid);
	
//		插入表
		RealDAOProxy proxy= new RealDAOProxy();
        int b=proxy.insertReal(real);
        System.out.print("b "+b);
		if(b!=0){
		request.getRequestDispatcher("gotostu.jsp").forward(request, response);}
	
	}
//获得创建表的ID号

}
