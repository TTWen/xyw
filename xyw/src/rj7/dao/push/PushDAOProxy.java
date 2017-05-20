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
		boolean flag = false;
		if(dao.doCreate(t)){
			flag = true;
		}
		return flag;
	}

	//删除推送
	public boolean doDelete(String pid) throws Exception {
		boolean flag = false;
		if(this.dao.doDelete(pid)){
			flag = true;
		}
		return flag;
	}
	//修改推送
	public boolean doUpdate(Push t) throws Exception {
		boolean flag = false;
		if(this.dao.doUpdate(t)){
			flag = true;
		}
		return flag;
	}

	//查找所有
	public ArrayList<Push> findAll() throws Exception {
		ArrayList<Push> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	//按照id查找
	public Push findByid(String pid) throws Exception {
		Push p = null;
		p = this.dao.findByid(pid);
		return p; 
	}

	//按照类型查找
	public ArrayList<Push> findBytype(String type) throws Exception {
		ArrayList<Push> list = null;
		list = this.dao.findBytype(type);
		return list; 
	}

	//按照热度查找
	public ArrayList<Push> findByhot() throws Exception {
		ArrayList<Push> list = null;
		list = this.dao.findByhot();
		return list; 
	}
	
	//按照时间查找
	public ArrayList<Push> findBytime(Date datebefore, Date dateafter) throws Exception {
		ArrayList<Push> list = null;
		list = this.dao.findBytime(datebefore, dateafter);
		return list; 
	}

	//查找最近
	public ArrayList<Push> findRecent(Date date) throws Exception {
		ArrayList<Push> list = null;
		list = this.dao.findRecent(date);
		return list; 
	}

}
