package rj7.dao.traveltipcmt;
import rj7.bean.traveltipcmt;
import java.util.List;

/**
 * 
 * 
 * 
 */
public interface ItraveltipcmtDAO  {

	
	public boolean doCreate(traveltipcmt ttid)throws Exception;//增加评论
	public boolean doDelete(String ttid)throws Exception;//删除评论
	public boolean doUpdate(traveltipcmt ttid)throws Exception;//更新评论
    public Object findByid(String ttid)throws Exception; //按ID查找
}

 
