package rj7.dao.tuisong;

import rj7.bean.Tuisong;
import rj7.util.Connect;

//推送的代理类
public class TuisongDAOproxy implements TuisongDAO {
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

	

}
