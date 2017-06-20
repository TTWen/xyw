package rj7.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;
import rj7.util.DateUtil;

public class PushRefreshServ
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Date date = new Date();
    Date recent = DateUtil.getDate(date, -10);
    PushDAOProxy pro = new PushDAOProxy();
    ArrayList<Push> hotpush = null;
    try
    {
    	hotpush = pro.findByhot(recent, date);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    request.setAttribute("hotpush", hotpush);
    request.getRequestDispatcher("index3.jsp").forward(request, response);
  }
}
