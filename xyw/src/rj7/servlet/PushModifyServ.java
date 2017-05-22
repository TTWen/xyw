package rj7.servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
			//推送对象
			Push t = new Push();
			//推送代理类
			PushDAOProxy tp = new PushDAOProxy();
			//将获取的页面信息封装到javabean
			//创建factory类用以将文件封装成fileitem  
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    //设置内存的临界值为500K
		    factory.setSizeThreshold(1024 * 500);  
	        //当超过500K的时候，存到一个临时文件夹中  
	        File temp = new File("d:\\temp");
	        //创建一个文件上传解析器
	        factory.setRepository(temp);   
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        //解决上传文件名的中文乱码  
	        upload.setHeaderEncoding("UTF-8"); 
	        //设置上传的文件总的大小不能超过5M  
	        upload.setSizeMax(1024 * 1024 * 5);
	        try {  
	            //  得到 FileItem 的集合 items  
				List<FileItem> items = upload.parseRequest(request);  
	            // 遍历 items: 在服务器写入文件 
	            for (FileItem item : items) {  
	            	//当获取的字段为普通字段时:
	            	if(item.isFormField()){
	            		String name = item.getFieldName();
	            		System.out.println("==============name:"+name);
	            		String value = item.getString("utf-8");
	            		System.out.println("==============value:"+value);
	            		if("pid".equals(name)){
	            			t.setPid(value);
	            		}
	            		if("head".equals(name)){
	            			t.setHead(value);
	            		}
	            		if("content".equals(name)){
	            			t.setContent(value);
	            		}
	            		if("type".equals(name)){
	            			t.setType(value);
	            		}
	            		//原图url
	            		if("urlpush".equals(name)){
	            			t.setUrlpush(value);
	            		}
	            	} else {
	            		//当获取的字段为文件时:
	            		//获取上传文件的文件名（含有路径）
	                    String fileName = item.getName();
	                    //文件不为空：
	                    if(!(fileName.equals(null))){
	                    	//截取需要的文件名
		                    int index=fileName.lastIndexOf("\\");
		            		if(index!=-1) {
		            			    fileName=fileName.substring(index+1);
		            		}
		                    //以流的形式返回上传文件符数据内容
		                    InputStream in = (InputStream) item.getInputStream();
		                    byte[] buffer = new byte[1024];  
		                    int len = 0;  
		                    //文件上传至服务器中的位置
		                    fileName = "d:\\pushimages\\"+fileName;
		                    //为url重新赋值
		                    t.setUrlpush(fileName);
		                    System.out.println("==============url:"+t.getUrlpush());
		                    OutputStream out = new FileOutputStream(fileName);  
		                    while ((len = in.read(buffer)) != -1) {  
		                        out.write(buffer, 0, len);  
		                    }  
		                    //关闭输入输出流
		                    out.close();  
		                    in.close();  
		            	}
		            }
	            }
					if(tp.doUpdate(t)){
						request.setAttribute("reback","修改成功！");
						System.out.println("============updateok");
					} else {
						request.setAttribute("reback","修改失败！");
						System.out.println("============updatefail");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
	        response.sendRedirect("push_modify.jsp");
	        return;
    }
	        
}
