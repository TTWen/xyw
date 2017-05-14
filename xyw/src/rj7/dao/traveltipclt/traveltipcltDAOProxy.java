package rj7.dao.traveltipclt;

import rj7.bean.traveltipclt;
import rj7.util.Connect;


	public class traveltipcltDAOProxy implements ItraveltipcltCDAO {
		traveltipcltDAOImpl dao =  new traveltipcltDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(traveltipclt t) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(dao.doCreate(t)){
				flag = true;
			}
			return flag;
		}
		
	public boolean doDelete(String glid) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(this.dao.doDelete(glid)){
				flag = true;
			}
			return flag;
		}
	
	public boolean doUpdate(traveltipclt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(t)){
			flag = true;
		}
		return flag;
	}


	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(glid);
		return obj; 
	}	
}


