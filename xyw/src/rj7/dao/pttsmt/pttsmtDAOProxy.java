package rj7.dao.pttsmt;

import rj7.bean.pttsmt;
import rj7.util.Connect;


	public class pttsmtDAOProxy implements IpttsmtDAO {
		pttsmtDAOImpl dao =  new pttsmtDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(pttsmt t) throws Exception {
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
	
	public boolean doUpdate(pttsmt t) throws Exception {
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


