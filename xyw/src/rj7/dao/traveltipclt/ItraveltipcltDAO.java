package rj7.dao.traveltipclt;
import rj7.bean.traveltipclt;


/**
 * 
 * 
 * 
 */
public interface ItraveltipcltDAO  {

	
	public boolean doCreate(traveltipclt t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(traveltipclt t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 


