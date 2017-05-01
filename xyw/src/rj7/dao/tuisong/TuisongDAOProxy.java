package rj7.dao.tuisong;
import java.util.*;
import rj7.bean.Tuisong;
import rj7.util.Connect;

//推送的代理类
public class TuisongDAOProxy implements ITuisongDAO {
	TuisongDAOImpl dao =  new TuisongDAOImpl();
	Connect conn = Connect.getInstance();
	@Override
	//增加推送
	public boolean doCreate(Tuisong t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(dao.doCreate(t)){
			flag = true;
		}
		return flag;
	}

	@Override
	//删除推送
	public boolean doDelete(String tid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doDelete(tid)){
			flag = true;
		}
		return flag;
	}
	//修改推送
	public boolean doUpdate(Tuisong t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(t)){
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
	
	
	@Override
	//按照id查找
	public Object findByid(String tid) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(tid);
		return obj; 
	}

	@Override
	//按照类型查找
	public List<Object> findBytype(String type) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findBytype(type);
		return list; 
	}

	

	@Override
	//按照热度查找
	public List<Object> findByhot() throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findByhot();
		return list; 
	}
	
}
