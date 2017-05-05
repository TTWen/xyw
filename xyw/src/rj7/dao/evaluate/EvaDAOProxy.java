package rj7.dao.evaluate;


import rj7.bean.Evaluate;
import java.util.*;
import rj7.util.Connect;

//预约的代理类
public class EvaDAOProxy implements IEvaDAO {
	EvaDAOImpl dao =  new EvaDAOImpl();
	Connect conn = Connect.getInstance();
	
	@Override
	//增加预约
	public boolean doCreate(Evaluate e) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(dao.doCreate(e)){
			flag = true;
		}
		return flag;
	}

	@Override
	//删除预约
	public boolean doDelete(String evaid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doDelete(evaid)){
			flag = true;
		}
		return flag;
	}
	//修改评价
	public boolean doUpdate(Evaluate r) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(r)){
			flag = true;
		}
		return flag;
	}

	
	@Override
	//查找所有
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	
	
	//按照评价id查找
	public Object findByid(String id,String tblname,String idname) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(id,tblname,idname);
		return obj; 
	}
	
	
	@Override
	//按用户id查找
	public List<Object> findByuserid(String userid) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findByuserid(userid);
		return list; 
	}


	@Override
	//按照评价星级数查找
	public List<Object> findBystar(String evastar) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findBystar(evastar);
		return list; 
	}
}



