package rj7.dao.tuisong;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import rj7.bean.Tuisong;
import rj7.util.Connect;
//推送接口实现

public class TuisongDAOImpl implements TuisongDAO {
	@Override
	//添加推送
	public boolean doCreate(Tuisong t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();
		//获取连接实例
		String sql = "insert into tbltuisong"
				+ "(tid,admid,ttype,thead,tcontent,ttime,tstatus,browsecnt,dianzancnt,zhuanfacnt,pingluncnt)"
				+"values(?,?,?,?,?,?,?,?,?,?,?)";			//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getTid());							//向param中添加参数
			param.add(t.getAdmid());
			param.add(t.getTtype());
			param.add(t.getThead());
			param.add(t.getTcontent());
			param.add(t.getTtime());
			param.add(t.getTstatus());
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
		String sql = "update tbltuisong set admid=?,ttype=?,thead=?,tcontent=?,ttime=?,"
				+ "tstatus=?,browsecnt=?,dianzancnt=?,zhuanfacnt=?,pingluncnt=?"+
				"where tid = ?";							//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getAdmid());						//向param中添加参数
			param.add(t.getTtype());
			param.add(t.getThead());
			param.add(t.getTcontent());
			param.add(t.getTtime());
			param.add(t.getTstatus());
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
}
