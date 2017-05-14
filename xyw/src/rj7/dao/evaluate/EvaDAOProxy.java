package rj7.dao.evaluate;
import rj7.bean.Evaluate;
import java.util.*;
/**
 * 
 * @author zf
 * 2017-05-08
 * 评价代理类
 *
 */

//评价的代理类
public class EvaDAOProxy implements IEvaDAO {
	EvaDAOImpl dao =  new EvaDAOImpl();
	
	//增加评价
	public boolean doCreate(Evaluate e) throws Exception {
		boolean flag = false;
		if(dao.doCreate(e)){
			flag = true;
		}
		return flag;
	}

	//删除评价
	public boolean doDelete(String evaid) throws Exception {
		boolean flag = false;
		if(this.dao.doDelete(evaid)){
			flag = true;
		}
		return flag;
	}
	//修改评价
	public boolean doUpdate(Evaluate r) throws Exception {
		boolean flag = false;
		if(this.dao.doUpdate(r)){
			flag = true;
		}
		return flag;
	}
	
	//查找所有评价
	public List<Object> findAll() throws Exception {
		List<Object> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	//按照评价id查找评价
	public Object findByid(String id,String tblname,String idname) throws Exception {
		Object obj = null;
		obj = this.dao.findByid(id,tblname,idname);
		return obj; 
	}
	
	//按用户id查找评价
	public List<Object> findByuserid(String userid) throws Exception {
		List<Object> list = null;
		list = this.dao.findByuserid(userid);
		return list; 
	}
	
	//按照评价星级数查找评价
	public List<Object> findBystar(String evastar) throws Exception {
		List<Object> list = null;
		list = this.dao.findBystar(evastar);
		return list; 
	}
}



