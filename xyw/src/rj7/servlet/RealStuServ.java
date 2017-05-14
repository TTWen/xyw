package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Real;
import rj7.dao.real.RealDAOProxy;

/**
 * 对于学生身份认证的处理servlet
 * @author 史国梅  2017.5.8
 *
 */
@WebServlet("/RealStuServ")
public class RealStuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RealStuServ() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

//	插入学生的信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单数据		

		response.setContentType("text/html");
		
		response.setCharacterEncoding("utf-8");
//		参数
		String rid=request.getParameter("rid");
		String school=request.getParameter("school");
		String major=request.getParameter("major");
		String qq=request.getParameter("qq");
		String ris="0";
//		给表字段赋值
		Real real=new Real();
		real.setSchool(school);
		real.setMajor(major);
		real.setRis(ris);
		real.setRid(rid);
		real.setQq(qq);
	
//		插入表
		RealDAOProxy proxy= new RealDAOProxy();
		if(proxy.insertRealstu(real)!=0){
		request.getRequestDispatcher("realcheck.jsp").forward(request, response);}
	}

}
