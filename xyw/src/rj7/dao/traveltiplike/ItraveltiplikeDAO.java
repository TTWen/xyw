package rj7.dao.traveltiplike;
import rj7.bean.traveltiplike;


/**
 * 
 * 
 * 
 */
public interface ItraveltiplikeDAO  {

	
	public boolean doCreate(traveltiplike t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(traveltiplike t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 
