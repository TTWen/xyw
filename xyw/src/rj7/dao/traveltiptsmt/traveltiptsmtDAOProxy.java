package rj7.dao.traveltiptsmt;

import rj7.bean.traveltiptsmt;
import rj7.util.Connect;


	public class traveltiptsmtDAOProxy implements ItraveltiptsmtFDAO {
		traveltiptsmtDAOImpl dao =  new traveltiptsmtDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(traveltiptsmt t) throws Exception {
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
	
	public boolean doUpdate(traveltiptsmt t) throws Exception {
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


