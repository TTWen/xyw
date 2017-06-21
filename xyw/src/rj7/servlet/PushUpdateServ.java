package rj7.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;

public class PushUpdateServ
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
    String pid = null;
    pid = request.getParameter("pid");
    PushDAOProxy tp = new PushDAOProxy();
    Push p = null;
    try
    {
      p = tp.findByid(pid);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    request.setAttribute("push", p);
    request.setAttribute("pid", pid);
    request.getRequestDispatcher("push_modify.jsp").forward(request, response);
  }
}
