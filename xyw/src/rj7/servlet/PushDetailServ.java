package rj7.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.bean.*;
import rj7.dao.push.PushDAOProxy;
import rj7.dao.pushcmt.pushcmtDAOProxy;
import java.util.*;
public class PushDetailServ
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
    //从页面评论跳转评论servlet，然后跳转至详情servlet，传递pid
    pid = request.getParameter("pid");
    PushDAOProxy tp = new PushDAOProxy();//推送代理类
    pushcmtDAOProxy pcmt = new pushcmtDAOProxy();//评论代理类
    Push p = null;//推送
    ArrayList<?> pc = null;//推送评论
    try
    {
      p = tp.findByid(pid);//获取推送id为pid的推送
      pc = (ArrayList<?>) pcmt.findByid(pid);//获取推送id为pid的评论,  dao方法应该获取集合！！
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    request.setAttribute("push", p);
    request.setAttribute("pushcmt", pc);
    request.getRequestDispatcher("push_details.jsp").forward(request, response);
  }
}
