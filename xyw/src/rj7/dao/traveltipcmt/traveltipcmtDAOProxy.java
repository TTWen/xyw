package rj7.dao.traveltipcmt;

import rj7.bean.traveltipcmt;
import rj7.util.Connect;


	public class traveltipcmtDAOProxy implements ItraveltipcmtDAO {
		traveltipcmtDAOImpl dao =  new traveltipcmtDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(traveltipcmt t) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(dao.doCreate(t)){
				flag = true;
			}
			return flag;
		}
		
	public boolean doDelete(String t) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(this.dao.doDelete(t)){
				flag = true;
			}
			return flag;
		}
	
	public boolean doUpdate(traveltipcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(t)){
			flag = true;
		}
		return flag;
	}


	
	public Object findByid(String ttid) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(ttid);
		return obj; 
	}	
}


