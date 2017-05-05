package rj7.dao.ptlike;

import rj7.bean.ptlike;

public interface IptlikeDAO  {

	
	public boolean doCreate(ptlike t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(ptlike t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 