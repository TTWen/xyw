package rj7.dao.pushclt;

import rj7.bean.pushclt;

public interface IpushcltDAO  {

	
	public boolean doCreate(pushclt t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(pushclt t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 