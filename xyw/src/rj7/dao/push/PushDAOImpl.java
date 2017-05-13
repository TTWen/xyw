package rj7.dao.push;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import rj7.bean.Push;
import rj7.util.Connect;
/**
 * @author lawonder
 * 2017/5/8
 * 推送接口实现
 */

public class PushDAOImpl implements IPushDAO {
	//获取连接实例
	static Connect conn = Connect.getInstance(); 
	//添加推送
	public boolean doCreate(Push t) throws Exception {
		boolean flag = false;
		//获取系统时间并进行格式化
		Date date = new Date();				
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
	    t.setTime(time);
	    //sql语句
	    //param为参数列表
		String sql = "insert into tblPush"
				+ "(pid,admid,type,head,content,time,status,browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt)"
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			ArrayList<Object> param = new ArrayList();
			//向param中添加参数
			param.add(t.getPid());							
			param.add(t.getAdmid());
			param.add(t.getType());
			param.add(t.getHead());
			param.add(t.getContent());
			param.add(t.getTime());
			param.add(t.getStatus());
			param.add(t.getBrowsecnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getCltcnt());
			//执行sql语句返回执行结果数
			//添加成功flag=true,否则flag=false
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}

	//删除推送
	public boolean doDelete(String pid) throws Exception {
		boolean flag = false;
		//sql语句
		//param为参数列表
		String sql = "delete from tblPush where pid = ?";	
			ArrayList<Object> param=new ArrayList();
			//向param中添加参数id
			param.add(pid);			
			//执行sql语句返回执行结果数
			//删除成功flag=true,否则flag=false
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}

	//修改推送
	public boolean doUpdate(Push t) throws Exception {
		boolean flag = false;
		//sql语句
		//param为参数列表
		String sql = "update tblPush set admid=?,type=?,head=?,content=?,time=?,"
				+ "status=?,browsecnt=?,likecnt=?,tsmtcnt=?,cmtcnt=?,shrecnt=?,cltcnt=?"+
				"where pid = ?";							
			ArrayList<Object> param = new ArrayList();
			//向param中添加参数
			param.add(t.getAdmid());						
			param.add(t.getType());
			param.add(t.getHead());
			param.add(t.getContent());
			param.add(t.getTime());
			param.add(t.getStatus());
			param.add(t.getBrowsecnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getShrecnt());
			param.add(t.getCltcnt());
			param.add(t.getPid());	
			//执行sql语句返回执行结果数
			//添加成功flag=true,否则flag=false
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	
	//查询所有推送,调用时注意判空！
	public List<Object> findAll() throws Exception {
		String sql = "select pid,admid,type,head,content,time,status,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush order by pid";
		//无参数时，param为null
		return conn.queryForArrObject(sql, null,Push.class);
	}

	//按照id查找,调用时注意判空！
	public Object findByid(String pid) throws Exception {
		//ps:在clt与from之间注意空格，否则出现语法错误
		String sql = "select pid,admid,type,head,content,time,status,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt"
				+ " from tblPush where pid = ?";
		//param为参数列表
		ArrayList<Object> param = new ArrayList();		
		param.add(pid);
		List<Object> rs = conn.queryForArrObject(sql, param,Push.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}

	//按照类型查找,调用时注意判空！
	public List<Object> findBytype(String type) throws Exception {
		String sql = "select pid,admid,type,head,content,time,status,"
				+ "browsecnt,tsmtcnt,likecnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush where type = ?";
		//param为参数列表
		ArrayList<Object> param = new ArrayList();		
		param.add(type);
		//以List<Object>形式返回
		return  conn.queryForArrObject(sql, param,Push.class);
	}

	//按照热度查找,调用时注意判空！
	public List<Object> findByhot() throws Exception {
		//根据点赞、转发、评论量等判断热度
		String sql = "select pid,admid,type,head,content,time,status,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush where (browsecnt+likecnt+tsmtcnt+cmtcnt+shrecnt+cltcnt)>500";
		//以List<Object>形式返回
		return conn.queryForArrObject(sql, null, Push.class);
	}
}
