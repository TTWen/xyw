package rj7.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.bean.Tuisong;
import rj7.dao.tuisong.TuisongDAOProxy;
/**
 * 推送servlet
 * @author 栾婉娜 2017/5/17
 *
 */
@WebServlet("/TuisongServ")
public class TuisongServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //构造方法   
    public TuisongServ() {
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
			if("ts_add".equals(flag)){
				this.doadd(request, response);
				}
			 else if("ts_delete".equals(flag)){
				this.dodelete(request, response);
			} else if("ts_modify".equals(flag)){
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
		Tuisong t = new Tuisong();
		//推送代理类
		TuisongDAOProxy tp = new TuisongDAOProxy();
		//将获取的页面信息封装到javabean
		t.setAdmid("80");
		t.setHead(request.getParameter("head"));
		t.setContent(request.getParameter("content"));
		t.setType(request.getParameter("type"));
		t.setBrowsecnt("0");
		t.setDianzancnt("0");
		t.setPingluncnt("0");
		//调用代理类方法进行添加
		if(tp.doCreate(t)){
			request.setAttribute("reback","添加成功");//键在前，值在后
		} else{
			request.setAttribute("reback","添加失败");
		}
		request.getRequestDispatcher("tuisong.jsp").forward(request, response);
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
