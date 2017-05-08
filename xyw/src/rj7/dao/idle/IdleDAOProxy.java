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

	private IIdleDAO dao = null;
	
	public IdleDAOProxy() throws Exception
	{
		this.dao = new IdleDAOImpl();
	}
	
	//按照id查找闲置物品
	public Object findById(String idleid) throws Exception
	{
		return (Object) this.dao.findById(idleid);		
	}
	
	//查找全部闲置物品
	public List<Object> findAll() throws Exception
	{
		List<Object> allIdle = null;
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

	//按照用户id查找其闲置物品
	public List<Object> findByUser(String memid) throws Exception {
		List<Object> useridle = null;
		try
		{
			useridle = this.dao.findByUser(memid);
		}
		catch(Exception e)
		{
			throw e;
		}
		return useridle;
	}
	
}