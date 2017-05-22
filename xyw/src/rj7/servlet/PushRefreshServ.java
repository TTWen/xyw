package rj7.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;
import rj7.util.DateUtil;
import rj7.util.Connect;

/**
 * lawonder 2017/5/20
 */
public class PushRefreshServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PushRefreshServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	//刷新页面，调用findhot方法将热点推送封装至list
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = new Date();
		Date recent = DateUtil.getDate(date, -10);
		PushDAOProxy pro = new PushDAOProxy();
		ArrayList<Push> push = null;
		try {
			push = pro.findByhot(recent, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("hotpush", push);
		request.getRequestDispatcher("push.jsp").forward(request, response);
	}

}
