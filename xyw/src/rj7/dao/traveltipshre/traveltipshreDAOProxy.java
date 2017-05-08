package rj7.dao.traveltipshre;

import rj7.bean.traveltipshre;
import rj7.util.Connect;


	public class traveltipshreDAOProxy implements ItraveltipshreXDAO {
		traveltipshreDAOImpl dao =  new traveltipshreDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(traveltipshre t) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(dao.doCreate(t)){
				flag = true;
			}
			return flag;
		}
		
	public boolean doDelete(String ttid) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			if(this.dao.doDelete(ttid)){
				flag = true;
			}
			return flag;
		}
	
	public boolean doUpdate(traveltipshre t) throws Exception {
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


