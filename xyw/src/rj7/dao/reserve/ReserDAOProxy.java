package rj7.dao.reserve;

import rj7.bean.Reserve;
import java.util.*;
import rj7.util.Connect;
/**
 * 
 * @author zf
 * 2017-05-08
 * 预约代理类
 *
 */
//预约代理类
public class ReserDAOProxy implements IReserDAO {
	ReserDAOImpl dao =  new ReserDAOImpl();
	Connect conn = Connect.getInstance();
	
	//添加预约	
	public boolean doCreate(Reserve r) throws Exception {
		boolean flag = false;
		if(dao.doCreate(r)){
			flag = true;
		}
		return flag;
	}

	//删除预约
	public boolean doDelete(String reserid) throws Exception {
		boolean flag = false;
		if(this.dao.doDelete(reserid)){
			flag = true;
		}
		return flag;
	}
	//修改预约
	public boolean doUpdate(Reserve r) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(r)){
			flag = true;
		}
		return flag;
	}

	//查找所有预约
	public List<Object> findAll() throws Exception {
		List<Object> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	//按预约id查找预约
	public Object findByid(String id,String tblname,String idname) throws Exception {
		Object obj = null;
		obj = this.dao.findByid(id,tblname,idname);
		return obj; 
	}

	//按预约用户id查找预约
	public List<Object> findByuserid(String userid) throws Exception {
		List<Object> list = null;
		list = this.dao.findByuserid(userid);
		return list; 
	}
	
	//按预约城市查找预约
	public List<Object> findBycity(String resercity) throws Exception {
		List<Object> list = null;
		list = this.dao.findBycity(resercity);
		return list; 
	}
}



