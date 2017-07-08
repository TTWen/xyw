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
		this.doPost(request, response);
		
	}

//	插入学生的信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			stureal(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



private void stureal (HttpServletRequest request, HttpServletResponse response)
		throws Exception{
	//获取表单数据		
	       
			response.setContentType("text/html");
			
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
//			参数
			String userid=(String)request.getSession().getAttribute("crtuid");
			String school=request.getParameter("school");
			String major=request.getParameter("major");
			String qq=request.getParameter("qq");
			String ris="0";
//			给表字段赋值
			RealDAOProxy proxy= new RealDAOProxy();
			
			Real real=new Real();
			real.setSchool(school);
			real.setMajor(major);
			real.setRis(ris);
			real.setUserid(userid);
			real.setQq(qq);
		
//			插入表
			System.out.print("用户 "+userid);
			int b=proxy.insertRealstu(real);
			if(b!=0){
			request.getRequestDispatcher("realcheck.jsp").forward(request, response);
			}
		}

}
			


