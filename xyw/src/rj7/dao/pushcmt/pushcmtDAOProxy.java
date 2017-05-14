package rj7.dao.pushcmt;

import rj7.bean.pushcmt;
import rj7.util.Connect;


	public class pushcmtDAOProxy implements IpushcmtDAO {
		pushcmtDAOImpl dao =  new pushcmtDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(pushcmt t) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(dao.doCreate(t)){
				flag = true;
			}
			return flag;
		}
		
	public boolean doDelete(String tsid) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(this.dao.doDelete(tsid)){
				flag = true;
			}
			return flag;
		}
	
	public boolean doUpdate(pushcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(t)){
			flag = true;
		}
		return flag;
	}


	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(tsid);
		return obj; 
	}	
}


