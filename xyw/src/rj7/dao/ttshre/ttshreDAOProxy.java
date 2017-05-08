package rj7.dao.ttshre;

import rj7.bean.ttshre;
import rj7.util.Connect;


	public class ttshreDAOProxy implements IttshreXDAO {
		ttshreDAOImpl dao =  new ttshreDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(ttshre t) throws Exception {
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
	
	public boolean doUpdate(ttshre t) throws Exception {
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


