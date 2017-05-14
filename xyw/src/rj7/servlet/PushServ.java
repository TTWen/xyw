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
 * 推送servlet
 * @author lawonder
 *  2017/5/17
 */
@WebServlet("/PushServ")
public class PushServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //构造方法   
    public PushServ() {
        super();
    }
    
	//GET方法，调用POST方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	//POST方法，根据flag值进行转发
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = null;
		flag = (String) request.getParameter("flag");
		try {
			if("push_add".equals(flag)){
				this.doadd(request, response);
				}
			 else if("push_delete".equals(flag)){
				this.dodelete(request, response);
			} else if("push_modify".equals(flag)){
				this.domodify(request, response);
			} else{
				this.dosearch(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//添加推送
	private void doadd(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//推送对象
		Push t = new Push();
		//推送代理类
		PushDAOProxy tp = new PushDAOProxy();
		//将获取的页面信息封装到javabean
		t.setAdmid("80");
		t.setHead(request.getParameter("head"));
		t.setContent(request.getParameter("content"));
		t.setType(request.getParameter("type"));
		t.setBrowsecnt("0");
		t.setCmtcnt("0");
		t.setCltcnt("0");
		t.setShrecnt("0");
		t.setTsmtcnt("0");
		t.setLikecnt("0");
		//调用代理类方法进行添加
		if(tp.doCreate(t)){
			request.setAttribute("reback","添加成功");//键在前，值在后
		} else{
			request.setAttribute("reback","添加失败");
		}
		request.getRequestDispatcher("push.jsp").forward(request, response);
		return;
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
	}

	private void domodify(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
	}

}
