package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
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
		
//      获取表单数据		
		response.setContentType("text/html");		
		response.setCharacterEncoding("utf-8");
//		参数
		String adress=request.getParameter("adress");
		String idcard=request.getParameter("idcard");
		String name=request.getParameter("name");
		String rid=request.getParameter("rid");		
		String post=request.getParameter("post");
//		给表字段赋值
		Real real=new Real();
		real.setRid(rid);
		real.setAdress(adress);
		real.setIdcard(idcard);
		real.setName(name);
		real.setPost(post);
	
//		插入表
		RealDAOProxy proxy= new RealDAOProxy();
		if(proxy.insertReal(real)!=0){
		request.getRequestDispatcher("gotostu.jsp").forward(request, response);}
	}

}
