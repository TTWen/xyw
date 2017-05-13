package rj7.dao.push;
import java.util.*;
import rj7.bean.Push;
import rj7.util.Connect;
/**
 * @author lawonder
 * 2017/5/8
 * 推送的代理类
 */

public class PushDAOProxy implements IPushDAO {
	PushDAOImpl dao =  new PushDAOImpl();
	Connect conn = Connect.getInstance();
	//增加推送
	public boolean doCreate(Push t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(dao.doCreate(t)){
			flag = true;
		}
		return flag;
	}

	//删除推送
	public boolean doDelete(String pid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doDelete(pid)){
			flag = true;
		}
		return flag;
	}
	//修改推送
	public boolean doUpdate(Push t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(t)){
			flag = true;
		}
		return flag;
	}

	//查找所有
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	//按照id查找
	public Object findByid(String pid) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(pid);
		return obj; 
	}

	//按照类型查找
	public List<Object> findBytype(String type) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findBytype(type);
		return list; 
	}

	//按照热度查找
	public List<Object> findByhot() throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findByhot();
		return list; 
	}
}
