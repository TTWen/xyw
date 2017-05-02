package rj7.dao.idle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rj7.bean.Idle;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * 闲置物品dao层接口实现
 * @author 闻婷  2017.4.23
 *
 */
public class IdleDAOImpl implements IIdleDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IdleDAOImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	//按照id查找闲置物品
	@Override
	public Idle findById(String id, String tblname ,String idname) {
		return (Idle) DAOFactory.getDaoInstance().findById(tblname, id, Idle.class, idname);
	}
	
	//查找全部闲置物品
	@Override
	public List<Idle> findAll()throws Exception
	{
		List<Idle> allIdle = new ArrayList();
		Idle idle = null;
		String sql = "select * from tblidle order by idleid";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next())
		{
			idle = new Idle();
			idle.setIdleid(rs.getString(1));
			idle.setMemid(rs.getString(2));
			idle.setIdlename(rs.getString(3));
			idle.setIdledetail(rs.getString(4));
			idle.setIdlepicurl(rs.getString(5));
			idle.setIdletype(rs.getString(6));
			idle.setIdletime(rs.getString(7));
			allIdle.add(idle);
		}
		this.pstmt.close();
		return allIdle;
	}
	
	//添加一个闲置物品
	@Override
	public boolean addIdle(Idle idle) throws Exception
	{
		boolean b = false;
		String sql  = "insert into tblidle(idleid, memid, idlename, idledetail, idlepicurl, idletype, idletime)values(?,?,?,?,?,?,?)";
		conn = Connect.getInstance().getConnection();
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, idle.getIdleid());
		pstmt.setString(2, idle.getMemid());
		pstmt.setString(3, idle.getIdlename());
		pstmt.setString(4, idle.getIdledetail());
		pstmt.setString(5, idle.getIdlepicurl());
		pstmt.setString(6, idle.getIdletype());
		pstmt.setString(7, idle.getIdletime());
		if(this.pstmt.executeUpdate() > 0)
		{
			b = true;
		}
		this.pstmt.close();
		conn.close();
		return b;
	}
	
	//删除一个闲置物品
	@Override
	public boolean deleteIdle(String idleid) throws Exception
	{
		boolean b = false;
		String sql = "delete from tblidle where idleid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, idleid);
		if(this.pstmt.executeUpdate() > 0)
		{
			b = true;
		}
		this.pstmt.close();
		conn.close();
		
		return b;
	}
	
	//修改一个闲置物品的信息
	@Override
	public boolean updateIdle(Idle idle) throws Exception
	{
		boolean b = false;
		String sql = "update tblidle set idlename=?,idledetail=?,idlepicurl=?,idletype=? where idleid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, idle.getIdlename());
		this.pstmt.setString(2, idle.getIdledetail());
		this.pstmt.setString(3, idle.getIdlepicurl());
		this.pstmt.setString(4, idle.getIdletype());
		this.pstmt.setString(5, idle.getIdleid());
		if(this.pstmt.executeUpdate() > 0)
		{
			b = true;
		}
		this.pstmt.close();
		conn.close();
		return b;
	}
}
