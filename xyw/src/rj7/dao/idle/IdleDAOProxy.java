package rj7.dao.idle;

import java.util.List;

import rj7.bean.Idle;
import rj7.util.Connect;

/**
 * 闲置物品dao层代理类
 * @author 闻婷  2017.4.23
 *
 */
public class IdleDAOProxy implements IIdleDAO {

	private Connect dbc = null;
	private IIdleDAO dao = null;
	
	public IdleDAOProxy() throws Exception
	{
		this.dbc  = new Connect();
		this.dao = new IdleDAOImpl(this.dbc.getConnection());
	}
	
	//按照id查找闲置物品
	@Override
	public Idle findById(String id, String tblname,String idname) 
	{
		return this.dao.findById(id, tblname, idname);		
	}
	
	//查找全部闲置物品
	@Override
	public List<Idle> findAll() throws Exception
	{
		List<Idle> allIdle = null;
		try
		{
			allIdle = this.dao.findAll();
		}
		catch(Exception e)
		{
			throw e;
		}
		return allIdle;
	}
	
	//添加一个闲置物品
	@Override
	public boolean addIdle(Idle idle)throws Exception
	{
		boolean b = false;
		try
		{
			b = this.dao.addIdle(idle);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}

	//删除一个闲置物品
	@Override
	public boolean deleteIdle(String idleid) throws Exception
	{
		boolean b = false;
		try
		{
			b = this.dao.deleteIdle(idleid);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}	
	
	//修改一个闲置物品的信息
	@Override
	public boolean updateIdle(Idle idle) throws Exception
	{
		boolean b = false;
		try
		{
			b = this.dao.updateIdle(idle);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}
	
}

/*class CanNotFindException extends Exception
{
	private String msg;
	CanNotFindException(String msg)
	{
		this.msg = msg;
	}
}*/







