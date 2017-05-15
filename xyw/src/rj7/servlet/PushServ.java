package rj7.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;
import rj7.util.DAO;
/**
 * 推送servlet
 * @author lawonder
 *  2017/5/17
 */
public class PushServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pagenum = 0;//保存当前页数
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
		//ps:未设置编码格式时，jsp参数传递至servl出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = null;
		flag = (String) request.getParameter("flag");
		try {
			if("push_add".equals(flag)){
				this.doadd(request, response);
			} else if("push_batch_delete".equals(flag)){
				this.dobatchdelete(request, response);
			} else if("push_modify".equals(flag)){
				this.domodify(request, response);
			} else if("push_find".equals(flag)){
				this.dofind(request, response);
			} else if("push_details".equals(flag)){
				this.dodetails(request, response);
			} else if("push_showlist".equals(flag)){
				this.showlist(request, response);
			} else{
				System.out.println("==============donothing");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//从其他页面跳转时，先跳转到servlet,参数flag=push_showlist,pageindex=0
	//dao.pageQuery方法从0页开始
	
	
	//获取页面对象,显示页面
	 private void showlist(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		 int pageindex;
		 //页面跳转pageindex!=null
		 //增删改后返回，pageindex=null
		 if(request.getParameter("pageindex")!=null){
			 pageindex = Integer.parseInt(request.getParameter("pageindex")) ;
			 this.pagenum = pageindex;
		 } else{
			 pageindex = pagenum;
		 }
		int pagenum = 10;
		request.setAttribute("curpagenum", pageindex);
		DAO dao = new DAO();
		List<Object> push = dao.pageQuery("tblpush", Push.class, pageindex, pagenum, null);
		PushDAOProxy pro = new PushDAOProxy();
		int count = pro.findAll().size();
		if(count%pagenum==0){
			request.setAttribute("pagecount", count/pagenum-1);
		} else{
			request.setAttribute("pagecount", count/pagenum);
		}
		request.setAttribute("pnum", pageindex);
		request.setAttribute("pageMember", push);
		request.getRequestDispatcher("pushmanage.jsp").forward(request, response);
		return;
	}
	

	//添加推送,根据flag判断执行结果
	private void doadd(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean flag = false;
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
			flag=true;
		} 
		request.setAttribute("reback",flag);
		this.showlist(request, response);//刷新页面
		return;
	}

	
	//批量删除，根据flag判断执行结果
	private void dobatchdelete(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		boolean flag = true;
		PushDAOProxy tp = new PushDAOProxy();
		String pid[]=request.getParameterValues("cbox");
		if(pid!=null){
		for(int i=0;i<pid.length;i++){
			if(!tp.doDelete(pid[i])){
				flag = false;
			}
		}
		request.setAttribute("reback",flag);
		this.showlist(request, response);//刷新页面
		}
	}
	

	//修改推送，根据flag判断执行结果
	private void domodify(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		boolean flag = false;
		PushDAOProxy tp = new PushDAOProxy();
		Push p = new Push();
		p.setPid(request.getParameter("pid"));
		p.setHead(request.getParameter("head"));
		p.setContent(request.getParameter("content"));
		p.setType((request.getParameter("select")));
		if(tp.doUpdate(p)){
			flag=true;
		}
		request.setAttribute("reback",flag);
		this.showlist(request, response);//刷新页面
	}
	
	
	//查询，用于网页修改时的自动填充
	private void dofind(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String pid = null;
		pid = request.getParameter("pid");
		PushDAOProxy tp = new PushDAOProxy();
		Push p = tp.findByid(pid);
		request.setAttribute("push", p);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("push_modify.jsp").forward(request, response);
	}

	
	//详情页面
	private void dodetails(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		String pid = null;
		pid = request.getParameter("pid");
		PushDAOProxy tp = new PushDAOProxy();
		Push p = new Push();
		p = tp.findByid(pid);
		request.setAttribute("push", p);
		request.getRequestDispatcher("push_details.jsp").forward(request, response);
	}

}
