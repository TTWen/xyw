package rj7.dao.pushlike;

import rj7.bean.pushlike;

public interface IpushlikeDAO  {

	
	public boolean doCreate(pushlike t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(pushlike t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 