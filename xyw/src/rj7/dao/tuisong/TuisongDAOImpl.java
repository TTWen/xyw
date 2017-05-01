package rj7.dao.tuisong;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import rj7.bean.Tuisong;
import rj7.util.Connect;
//推送接口实现

public class TuisongDAOImpl implements ITuisongDAO {
	@Override
	//添加推送
	public boolean doCreate(Tuisong t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance(); //获取连接实例
		Date date=new Date();				//获取系统时间并进行格式化
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	    t.setTime(time);
		String sql = "insert into tbltuisong"
				+ "(tid,admid,type,head,content,time,status,browsecnt,dianzancnt,zhuanfacnt,pingluncnt)"
				+"values(?,?,?,?,?,?,?,?,?,?,?)";			//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getTid());							//向param中添加参数
			param.add(t.getAdmid());
			param.add(t.getType());
			param.add(t.getHead());
			param.add(t.getContent());
			param.add(t.getTime());
			param.add(t.getStatus());
			param.add(t.getBrowsecnt());
			param.add(t.getDianzancnt());
			param.add(t.getZhuanfacnt());
			param.add(t.getPingluncnt());
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//添加成功flag=true,否则flag=false
	}

	@Override
	//删除推送
	public boolean doDelete(String tid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "delete from tbltuisong where tid = ?";	//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(tid);							//向param中添加参数id
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//删除成功flag=true,否则flag=false
	}

	@Override
	//修改推送
	public boolean doUpdate(Tuisong t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "update tbltuisong set admid=?,type=?,head=?,content=?,time=?,"
				+ "status=?,browsecnt=?,dianzancnt=?,zhuanfacnt=?,pingluncnt=?"+
				"where tid = ?";							//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getAdmid());						//向param中添加参数
			param.add(t.getType());
			param.add(t.getHead());
			param.add(t.getContent());
			param.add(t.getTime());
			param.add(t.getStatus());
			param.add(t.getBrowsecnt());
			param.add(t.getDianzancnt());
			param.add(t.getZhuanfacnt());
			param.add(t.getPingluncnt());
			param.add(t.getTid());	
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//添加成功flag=true,否则flag=false
	}
	
	@Override
	//查询所有推送,调用时注意判空！
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "select tid,admid,type,head,content,time,status,"
				+ "browsecnt,dianzancnt,zhuanfacnt,pingluncnt "
				+ "from tbltuisong order by tid";
		return conn.queryForArrObject(sql, null,Tuisong.class);//无参数时，param为null
	}

	@Override
	//按照id查找,调用时注意判空！
	public Object findByid(String tid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "select tid,admid,type,head,content,time,status,"
				+ "browsecnt,dianzancnt,zhuanfacnt,pingluncnt"
				+ " from tbltuisong where tid = ?";
		ArrayList<Object> param=new ArrayList();		//param为参数列表
		param.add(tid);
		List<Object> rs = conn.queryForArrObject(sql, param,Tuisong.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	//按照类型查找,调用时注意判空！
	public List<Object> findBytype(String type) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "select tid,admid,type,head,content,time,status,"
				+ "browsecnt,dianzancnt,zhuanfacnt,pingluncnt "
				+ "from tbltuisong where type = ?";
		ArrayList<Object> param=new ArrayList();		//param为参数列表
		param.add(type);
		return  conn.queryForArrObject(sql, param,Tuisong.class);//以List<Object>形式返回
	}

	@Override
	//按照热度查找,调用时注意判空！
	public List<Object> findByhot() throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "select tid,admid,type,head,content,time,status,"
				+ "browsecnt,dianzancnt,zhuanfacnt,pingluncnt "
				+ "from tbltuisong where (dianzancnt+zhuanfacnt+pingluncnt)>1000";//根据点赞、转发、评论量判断热度
		return conn.queryForArrObject(sql, null, Tuisong.class);//以List<Object>形式返回
	}

	
}
