package rj7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IdleUIServ")

/**
 * 闲置物品管理的界面servlet，只负责中转
 * @author TTWen  2017.5.5
 *
 */

public class IdleUIServ extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("updateidle".equals(method))
		{
			request.getRequestDispatcher("/idleupdate.jsp").forward(request, response);
		}
		if("addidle".equals(method))
		{
			request.getRequestDispatcher("/idleadd.jsp").forward(request, response);
		}
	}
}