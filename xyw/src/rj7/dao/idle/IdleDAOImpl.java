package rj7.dao.idle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Idle;
import rj7.util.Connect;

/**
 * 闲置物品dao层接口实现
 * @author 闻婷  2017.4.23
 *
 */
public class IdleDAOImpl implements IIdleDAO {
	
	private static Connect conn = Connect.getInstance();
	//按照id查找闲置物品
	public Object findById(String idleid)throws Exception
	{
		String sql = "select * from tblidle where idleid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(idleid);
		List<Object> rs = conn.queryForArrObject(sql, param,Idle.class);
		if(rs.size()!=0)
		{
			return rs.get(0);
		}
		else
		{
			return null;
		}
	}
	
	//按照用户id查找其闲置物品
	public List<Object> findByUser(String memid) throws Exception
	{
		String sql = "select * from tblidle where memid = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(memid);
		return  conn.queryForArrObject(sql, param, Idle.class);
	}
	
	
	//查找全部闲置物品
	public List<Object> findAll()throws Exception
	{
		List<Object> allidle = new ArrayList<Object>();
		String sql = "select * from tblidle order by idleid";
		allidle = conn.queryForArrObject(sql, null, Idle.class);
		return  allidle;
	}
	
	//添加一个闲置物品
	public boolean addIdle(Idle idle) throws Exception
	{
		boolean b = false;
		Date date=new Date();				
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	    idle.setIdletime(time);
		String sql  = "insert into tblidle(idleid, memid, idlename, idledetail, idlepicurl, idletype, idletime)values(?,?,?,?,?,?,?)";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idle.getIdleid());
		param.add(idle.getMemid());
		param.add(idle.getIdlename());
		param.add(idle.getIdledetail());
		param.add(idle.getIdlepicurl());
		param.add(idle.getIdletype());
		param.add(idle.getIdletime());
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}
	
	//删除一个闲置物品
	public boolean deleteIdle(String idleid) throws Exception
	{
		boolean b = false;
		String sql = "delete from tblidle where idleid = ?";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idleid);		
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}
	
	//修改一个闲置物品的信息
	public boolean updateIdle(Idle idle) throws Exception
	{
		boolean b = false;
		String sql = "update tblidle set memid=?,idlename=?,idledetail=?,idlepicurl=?,idletype=?,idletime=? where idleid=?";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idle.getMemid());
		param.add(idle.getIdlename());
		param.add(idle.getIdledetail());
		param.add(idle.getIdlepicurl());
		param.add(idle.getIdletype());
		param.add(idle.getIdletime());
		param.add(idle.getIdleid());
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}
}