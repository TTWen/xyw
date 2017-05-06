package rj7.dao.idle;
 
import java.util.List;
import rj7.bean.Idle;

/**
 * 闲置物品dao层接口
 * @author 闻婷  2017.4.23
 * 
 */
public interface IIdleDAO {
 
 	//按照id查找
 	public Idle findById(String id, String tblname,String idtype);
	
	//查找全部闲置物品
	public List<Idle> findAll()throws Exception;
 	
 	//添加一个闲置物品
 	public boolean addIdle(Idle idle) throws Exception;
 	
 	//删除一个闲置物品
 	public boolean deleteIdle(String idleid)throws Exception;
 	
 	//修改一个闲置物品的信息
 	public boolean updateIdle(Idle idle)throws Exception;
 }