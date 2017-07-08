package rj7.servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;
/**
 * lawonder 2017/5/20
 */
public class PushModifyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PushModifyServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			//推送对象
			Push t = new Push();
			//推送代理类
			PushDAOProxy tp = new PushDAOProxy();
			//将获取的页面信息封装到javabean
			t.setPid(request.getParameter("pid"));
		    t.setHead(request.getParameter("head"));
		    t.setContent(request.getParameter("content"));
		    t.setType(request.getParameter("type"));
		    t.setBrowsecnt(request.getParameter("browsecnt"));
		    t.setCltcnt(request.getParameter("cltcnt"));
		    t.setCmtcnt(request.getParameter("cmtcnt"));
		    t.setLikecnt(request.getParameter("likecnt"));
		    t.setShrecnt(request.getParameter("shrecnt"));
		    t.setTsmtcnt(request.getParameter("tsmtcnt"));
			try {
				if(tp.doUpdate(t)){
					request.setAttribute("reback","修改成功！");
				} else {
					request.setAttribute("reback","修改失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			    response.sendRedirect("pushmanage.jsp");
	        return;
    }
	        
}
