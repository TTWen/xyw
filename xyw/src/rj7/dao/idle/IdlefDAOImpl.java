package rj7.dao.idle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Idle;
import rj7.bean.IdleFile;
import rj7.util.Connect;

/**
 * 闲置物品图片dao层接口实现
 * @author TTWen 2017.6.19
 *
 */

public class IdlefDAOImpl  implements IIdlefDAO {
	
	private static Connect conn = Connect.getInstance();
	
	//按照图片id查找闲置物品图片
	public Object findById(String idlefid) throws Exception {
		String sql = "select * from tblidlef where idlefid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(idlefid);
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

	//按照闲置物品id查找闲置物品图片，返回该闲置物品的全部图片信息集合
	public List<Object> findByIdle(String idleid) throws Exception {
		String sql = "select * from tblidlef where idleid = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(idleid);
		List list = conn.queryForArrObject(sql, param, IdleFile.class);
		if(list.size()!=0)
		{
			IdleFile file = (IdleFile)list.get(0);
			return list;
		}else
			return null;
	}

	//查找全部闲置物品图片
	public List<Object> findAllIdlef() throws Exception {
		List<Object> allidlepic = new ArrayList<Object>();
		String sql = "select * from tblidlef order by idlefid";
		allidlepic = conn.queryForArrObject(sql, null, Idle.class);
		return  allidlepic;
	}

	//为一个闲置物品添加一个图片
	public boolean addIdlef(IdleFile idlefile) throws Exception {
		
		boolean b = false;
		Date date=new Date();				
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		idlefile.setIdlefupdatetime(time);
		String sql  = "insert into tblidlef(idlefid, idlefuuidname, idleffilename, idlefsavepath, fdir1, fdir2, idlefupdatetime, idleid)values(?,?,?,?,?,?,?,?)";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idlefile.getIdlefid());
		param.add(idlefile.getIdlefuuidname());
		param.add(idlefile.getIdleffilename());
		param.add(idlefile.getIdlefsavepath());
		param.add(idlefile.getFdir1());
		param.add(idlefile.getFdir2());
		param.add(idlefile.getIdlefupdatetime());
		param.add(idlefile.getIdleid());
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}

	//删除一个闲置物品的一张图片
	public boolean deleteIdlef(String idlefid) throws Exception {
		boolean b = false;
		String sql = "delete from tblidlef where idlefid = ?";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idlefid);		
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}
	
	//删除 一个闲置物品的所有图片
	public boolean deleteIdlefs(String idleid) throws Exception{
		boolean b = false;
		String sql = "delete from tblidlef where idleid = ?";
		ArrayList<Object> param=new ArrayList<Object>();
		param.add(idleid);		
		if(conn.update(sql, param)!=0)
		{
			b = true;
		}
		return b;
	}
}
