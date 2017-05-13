package rj7.dao.ttlike;
import rj7.bean.ttlike;


/**
 * 
 * 
 * 
 */
public interface IttlikeDAO  {

	
	public boolean doCreate(ttlike t)throws Exception;
	public boolean doDelete(String t)throws Exception;
	public boolean doUpdate(ttlike t)throws Exception;
    public Object findByid(String tid)throws Exception; 
}

 
