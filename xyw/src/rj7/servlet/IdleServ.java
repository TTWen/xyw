package rj7.servlet;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import rj7.bean.Idle;
import rj7.bean.IdleFile;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;

/**
 * @name 闲置物品的servlet 目前包括以下方法：
 * 		   查找所有用户全部闲置物品/按照用户id查找其全部闲置物品/添加一个闲置物品/删除一个闲置物品/更新一个闲置物品信息
 * @author TTWen 2017.5.5
 * @note：数据库的时间类型是datetime，可以存，但取出就是date类型（暂时还没改好
 */

@WebServlet("/IdleServ")
public class IdleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IdleServ() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		String method1 = request.getParameter("method1");
		List<Object> list = new ArrayList<Object>();//存放闲置物品信息的集合
				
		try
		{
			//method = allidle 查找全部方法
			if("allidle".equals(method))
			{
				request.getRequestDispatcher("IdleShowServ?method=allidle").forward(request, response);	
			}
			//method = findbyuser 按照用户id查找该用户的所有闲置物品
			if("findbyuser".equals(method))
			{
				request.getRequestDispatcher("IdleFindByUserServ?method=findbyuser").forward(request, response);	
			}
			//method = addidle 添加一个闲置物品
			if("addidle".equals(method))
			{
				request.getRequestDispatcher("IdleAddServ?method=addidle").forward(request, response);	
			}
			//method = deleteidle 删除一个闲置物品
			if("deleteidle".equals(method))
			{
				request.getRequestDispatcher("IdleDeleteServ?method=deleteidle").forward(request, response);	
			}
			//method = updateidle 更新修改一个闲置物品
			if("updateidle".equals(method))
			{
				String idleid = request.getParameter("idleid");
				String memid = request.getParameter("memid");
				request.getRequestDispatcher("IdleUpdateServ?idleid="+idleid+"&memid="+memid+"&method=updateidle").forward(request, response);	
			}
			//method=idledetail 查看一个闲置物品详情
			if("detailidle".equals(method))
			{
				request.getRequestDispatcher("IdleDetailServ?method=detailidle").forward(request, response);	
			}
			//删除某个闲置物品的一张图片
			if("deleteidlef".equals(method))
			{
				String idleid = request.getParameter("idleid");
				String memid = request.getParameter("memid");
				String idlefid = request.getParameter("idlefid");
				request.getRequestDispatcher("IdleDeletefServ?memid="+memid+"&idleid="+idleid+"&idlefid="+idlefid+"&method=deleteidlef").forward(request, response);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
