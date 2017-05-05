package rj7.dao.ttlike;

import rj7.bean.ttlike;
import rj7.util.Connect;


	public class ttlikeDAOProxy implements IttlikeDAO {
		ttlikeDAOImpl dao =  new ttlikeDAOImpl();
		Connect conn = Connect.getInstance();
		@Override
		//澧炲姞鎺ㄩ��?
		public boolean doCreate(ttlike t) throws Exception {
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
	
	public boolean doUpdate(ttlike t) throws Exception {
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


