package rj7.dao.pushcmt;

import rj7.bean.pushcmt;

public interface IpushcmtDAO  {

	
	public boolean doCreate(pushcmt t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(pushcmt t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 