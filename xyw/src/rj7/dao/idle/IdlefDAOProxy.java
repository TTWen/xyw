package rj7.dao.idle;

import java.util.List;

import rj7.bean.Idle;
import rj7.bean.IdleFile;

/**
 * 闲置物品图片dao层代理类
 * @author TTWen 2017.6.19
 *
 */
public class IdlefDAOProxy implements IIdlefDAO{

	private IIdlefDAO dao = null;
	
	public IdlefDAOProxy() throws Exception
	{
		this.dao = new IdlefDAOImpl();
	}
	
	//按照闲置物品图片id查找
	@Override
	public Object findById(String idlefid) throws Exception {
		return this.dao.findById(idlefid);
	}

	//按照闲置物品id查找其所有闲置物品图片
	@Override
	public List<Object> findByIdle(String idleid) throws Exception {
		List<Object> useridle = null;
		try
		{
			useridle =(List<Object>)this.dao.findByIdle(idleid);
		}
		catch(Exception e)
		{
			throw e;
		}
		return useridle;
	}

	//查找全部闲置物品图片
	@Override
	public List<Object> findAllIdlef() throws Exception {
		List<Object> allIdle = null;
		try
		{
			allIdle = this.dao.findAllIdlef();
		}
		catch(Exception e)
		{
			throw e;
		}
		return allIdle;
	}
	//为一个闲置物品添加一个闲置物品图片
	@Override
	public boolean addIdlef(IdleFile idlefile) throws Exception {
		boolean b = false;
		try
		{
			b = this.dao.addIdlef(idlefile);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}

	//删除一个闲置物品的图片
	@Override
	public boolean deleteIdlef(String idlefid) throws Exception {
		boolean b = false;
		try
		{
			b = this.dao.deleteIdlef(idlefid);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}

	//删除一个闲置物品的所有图片
	@Override
	public boolean deleteIdlefs(String idleid) throws Exception {
		boolean b = false;
		try
		{
			b = this.dao.deleteIdlefs(idleid);
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}
}
