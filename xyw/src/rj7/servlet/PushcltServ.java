package rj7.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rj7.bean.pushclt;
import rj7.dao.pushclt.pushcltDAOProxy;

/**
 * 推送点赞servlet
 *  @author 郑向前
 *  2017-5-15
 */
@WebServlet("/PushcltServ")
public class PushcltServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//构造方法
    public PushcltServ() {
        super();   
    }

	//GET方法，调用POST方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	//POST方法，根据flag值进行操作
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String flag = null;
		flag = (String) request.getParameter("flag");//parameter参数
		try {
			  if("pushclt_add".equals(flag)){
				  this.doadd(request,response);
			  }
			  else if("pushclt_delete".equals(flag)){
				  this.dodelete(request, response);
			  }else if("pushclt_modify".equals(flag)){
				  this.domodify(request,response);
			  }else{
				  this.dosearch(request,response);
			  }  
	    }catch (Exception e){
	    	e.printStackTrace();
	    }	
		
	}

	
	
	//添加推送点赞
	private void doadd(HttpServletRequest request, HttpServletResponse response)
	                throws Exception{
		//推送点赞对象
		pushclt t = new pushclt();
		//推送代理类
		pushcltDAOProxy tp= new pushcltDAOProxy();
		//将获取的页面信息封装到javabean
        //		t.setPtid("3");
		t.setCltid(request.getParameter("cltname"));
		t.setCltdid(request.getParameter("cltdname"));
		
      	//调用代理类方法进行添加
		if(tp.doCreate(t)){
			request.setAttribute("reback", "添加成功");//键前值后
		}else{
			request.setAttribute("reback", "添加失败");
		}
		request.getRequestDispatcher("pushclt.jsp").forward(request, response);
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
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
