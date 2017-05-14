package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.dao.real.RealDAOProxy;
@WebServlet("/RealCekServ")
/**
 * 对于管理员审核结果的处理servlet
 * @author 史国梅  2017.5.8
 *
 */
public class RealCekServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RealCekServ() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取表单数据		
		response.setContentType("text/html");		
		response.setCharacterEncoding("utf-8");
//		参数
		String check=request.getParameter("check");
		String rid=request.getParameter("rid");
//		通过和不通过的处理
		RealDAOProxy proxy= new RealDAOProxy();
		if(check=="1"){                          //通过
			proxy.editRis(rid);
			request.getRequestDispatcher("realcheck.jsp").forward(request, response);
		}
		else{                          //不通过
			proxy.deleteReal(rid);
			request.getRequestDispatcher("realcheck.jsp").forward(request, response);
		}		
	}
}
