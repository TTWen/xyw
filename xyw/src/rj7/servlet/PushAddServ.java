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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import rj7.bean.Push;
import rj7.dao.push.PushDAOProxy;

public class PushAddServ
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
    Push t = new Push();
    PushDAOProxy tp = new PushDAOProxy();
    t.setAdmid("80");
    t.setCmtcnt("0");
    t.setCltcnt("0");
    t.setShrecnt("0");
    t.setTsmtcnt("0");
    t.setLikecnt("0");
    t.setBrowsecnt("0");
    t.setStatus("0");
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(512000);
    File temp = new File("e:\\temp");
    factory.setRepository(temp);
    ServletFileUpload upload = new ServletFileUpload(factory);
    upload.setHeaderEncoding("UTF-8");
    upload.setSizeMax(115242880L);
    try
    {
      @SuppressWarnings("unchecked")
	List<FileItem> items = upload.parseRequest(request);
      String fileName = "e:\\pushimages\\ ";
      for (FileItem item : items) {
        if (item.isFormField())
        {
          String name = item.getFieldName();//字段属性name
          String value = item.getString("utf-8");
          if ("head".equals(name)) {
            t.setHead(value);
          }
          if ("content".equals(name)) {
            t.setContent(value);
          }
          if ("type".equals(name)) {
            t.setType(value);
          }
        }
        else
        {
           
          String fName = item.getName();//文件名
          if (!"".equals(fName))
          {
            int index = fName.lastIndexOf("\\");
            if (index != -1) {
              fName = fName.substring(index + 1);
            
            }
            InputStream in = item.getInputStream();//流形式返回文件上传
            byte[] buffer = new byte[1024];
            int len = 0;
            fileName = fileName + fName+' ';
            fName = "e:\\pushimages\\" + fName;
            OutputStream out = new FileOutputStream(fName);//输出位置
            while ((len = in.read(buffer)) != -1) {
              out.write(buffer, 0, len);
            }
            in.close();
            out.close();
          }
          t.setUrlpush(fileName);
        }
      }
     
    }
    catch (FileUploadException e)
    {
      e.printStackTrace();
    }
    try
    {
      if (tp.doCreate(t)) {
        request.setAttribute("reback", "添加成功！");
      } else {
        request.setAttribute("reback", "添加失败！");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    request.getRequestDispatcher("push_add.jsp").forward(request, response);
  }
}
