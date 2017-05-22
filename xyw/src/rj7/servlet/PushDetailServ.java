package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;

/**
 * lawonder
 * 2017/5/21
 */
public class PushDetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PushDetailServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pid = null;
		pid = request.getParameter("pid");
		PushDAOProxy tp = new PushDAOProxy();
		Push p = new Push();
		try {
			p = tp.findByid(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("push", p);
		request.getRequestDispatcher("push_details.jsp").forward(request, response);
	}
	

}
