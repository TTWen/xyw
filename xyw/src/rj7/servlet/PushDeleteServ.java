package rj7.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.dao.push.PushDAOProxy;

public class PushDeleteServ
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
    PushDAOProxy tp = new PushDAOProxy();
    String[] pid = request.getParameterValues("cbox");
    if (pid != null)
    {
      for (int i = 0; i < pid.length; i++) {
        try
        {
          tp.doDelete(pid[i]);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
      request.getRequestDispatcher("PushShowServ").forward(request, response);
    }
  }
}
