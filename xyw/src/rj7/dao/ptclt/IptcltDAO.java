package rj7.dao.ptclt;

import rj7.bean.ptclt;

public interface IptcltDAO  {

	
	public boolean doCreate(ptclt t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(ptclt t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 