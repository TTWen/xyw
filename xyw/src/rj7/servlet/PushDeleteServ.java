package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.dao.push.PushDAOProxy;

/**
 * lawonder
 * 2017/5/21
 */
public class PushDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PushDeleteServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PushDAOProxy tp = new PushDAOProxy();
		String pid[]=request.getParameterValues("cbox");
		if(pid!=null){
		for(int i=0;i<pid.length;i++){
			try {
				tp.doDelete(pid[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//自动回到原来的页面？？？
		request.getRequestDispatcher("PushShowServ").forward(request, response);//刷新页面
		}
	}

}
