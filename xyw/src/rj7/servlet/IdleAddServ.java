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
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import rj7.bean.Idle;
import rj7.bean.IdleFile;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.idle.IdlefDAOProxy;

/**
 * Servlet implementation class IdleAddServ
 */
@WebServlet("/IdleAddServ")
public class IdleAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IdleAddServ() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		List<Object> list = new ArrayList<Object>();//存放闲置物品信息的集合
		
		try
		{
			IdleDAOProxy proxy = new IdleDAOProxy();
			IdlefDAOProxy fproxy = new IdlefDAOProxy();
			boolean b = false;
			String memid = request.getParameter("memid");
			Idle idle = new Idle();
			String idleidget = null;
			List types = Arrays.asList("jpg", "jpeg", "png", "gif");
			try {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					
					factory.setSizeThreshold(1024*1024*10);//如果超过10M，就用缓冲区来保存写到临时文件里去，再从临时文件取数据放到要保存的目录下
					factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));//保存临时文件的目录(保存在指定的硬盘目录下)
					factory.setRepository(new File("\temp"));//保存在Tomcat服务器对应的目录下
					
					ServletFileUpload upload = new ServletFileUpload(factory);
					
					upload.setFileSizeMax(1024*1024*10);//这里接受的是long类型，是字节，所以这是10M
					if(!upload.isMultipartContent(request))//判断是上传文件表单还是普通输入表单
					{//如果不是上传文件表单，就不用按照解析器解析的方式进行处理，按照传统方式获取表单数据
						System.out.println("我不是上传文件表单");
						idle.setMemid(request.getParameter("memid"));
						idle.setIdlename(request.getParameter("idlename"));
						idle.setIdledetail(request.getParameter("idledetail"));
						idle.setIdletype(request.getParameter("idletype"));
						
						Date date=new Date();
						DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String time=format.format(date);
						idle.setIdletime(time);
						return;
					}
					//如果是上传文件表单，就执行以下代码
					upload.setHeaderEncoding("UTF-8");//解决文件名为中文的乱码问题
					List<FileItem> list1 = upload.parseRequest(request);//解析后，每个输入项都变成一个 item，返回到一个list集合
				
					for(FileItem item:list1)
					{
						
						if(item.isFormField())//item 为普通输入项
						{
							String inputName = item.getFieldName();//得到名称
							String inputValue = item.getString("UTF-8");
							if("memid".equals(inputName))
							{
								idle.setMemid(inputValue);
							}
							else if("idlename".equals(inputName))
							{
								idle.setIdlename(inputValue);
							}
							else if("idledetail".equals(inputName))
							{
								idle.setIdledetail(inputValue);
							}
							else if("idletype".equals(inputName))
							{
								idle.setIdletype(inputValue);
								b = new IdleDAOProxy().addIdle(idle);
								
								Idle tempidle = (Idle) proxy.findLastByIdle(memid);//根据用户id获取最后一个闲置物品的
								
								//这里要得到idleid
								idleidget = tempidle.getIdleid();
							}
						}
						else//item 为上传文件
						{
							IdleFile file = new IdleFile();
							String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);
							
							if(filename == null || filename.trim() == null)//有的item项没有文件上传
							{
								continue;//这个输入项没有文件上传，进行下一次循环，对下一个输入项进行处理，不能return！！
							}
							
							//有限制要上传的文件类型，拿到文件名后要做一个判断
							String ext = filename.substring(filename.lastIndexOf(".")+1);//获取文件的扩展名
							if(!types.contains(ext))
							{
								request.setAttribute("message", "本系统不支持‘"+ext+"’类型文件的上传");
								request.getRequestDispatcher("/message.jsp").forward(request, response);
								return;
							}
							file.setIdleffilename(filename);
							InputStream in = item.getInputStream();
							int len = 0;
							byte buffer[] = new byte[1024];
							//这样写是保存到Tomcat服务器里的
							//String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
							//FileOutputStream out = new FileOutputStream(this.getServletContext().getRealPath("/WEB-INF/upload")+ "\\" +filename);
							//这样写是保存到指定硬盘的
							String savepath = "C:\\Users\\TTWen\\git\\xyw\\xyw\\WebContent\\idlefupload";
							String saveFileName = generateFileName(filename);
							file.setIdlefuuidname(saveFileName);
							
							savepath = generateSavePath(savepath, saveFileName, file);
							file.setIdlefsavepath(savepath);
							
							Date date=new Date();
							DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String time=format.format(date);
							file.setIdlefupdatetime(time);
							file.setIdleid(idleidget);
							fproxy = new IdlefDAOProxy();
							boolean inb = fproxy.addIdlef(file);
							if(inb)
							{
								System.out.println("图片插入成功");
							}
							
							FileOutputStream out = new FileOutputStream(savepath+ File.separator +saveFileName);//保存文件
							
							while((len=in.read(buffer))>0)
							{
								out.write(buffer, 0, len);
							}
							in.close();
							out.close();
							item.delete();//删除临时文件,本行代码必须在流关闭之后
						}
					}
					
					if(b)
					{
						request.setAttribute("message","添加闲置物品成功!浏览器将在3s后自动跳转到闲置物品展示页~~~如果没有跳转，请点击...<meta http-equiv='refresh' content='3;url=IdleServ?method=allidle'>" );
						request.getRequestDispatcher("/message.jsp").forward(request, response);
					}
			} catch (FileUploadBase.FileSizeLimitExceededException e) {//该异常是文件大小超过设置的文件大小所抛的异常
				request.setAttribute("message", "文件大小不能超过10m");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			} 
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public String generateSavePath(String path, String filename, IdleFile filee)
	{//采用多级目录打散多存，使得文件不会出现多个文件存放在一个目录下造成访问速度过慢
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;//得到低四位
		int dir2 = (hashcode>>4) & 0xf;
		filee.setFdir1((dir1+"").trim());
		filee.setFdir2((dir2+"").trim());
		
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		File file = new File(savepath);
		if(!file.exists())
		{
			file.mkdirs();//多级目录创建要用复数形式
		}
		return savepath;
	}

	//为每个文件产生一个唯一的文件名保证相同文件名不会被替换或覆盖
	public String generateFileName(String filename){
		return UUID.randomUUID().toString() + "_" + filename;
	}
}

