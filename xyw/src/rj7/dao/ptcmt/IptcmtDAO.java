package rj7.dao.ptcmt;

import rj7.bean.ptcmt;

public interface IptcmtDAO  {

	
	public boolean doCreate(ptcmt t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(ptcmt t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 