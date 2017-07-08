package rj7.dao.idle;

import java.util.List;

import rj7.bean.Idle;
import rj7.bean.IdleFile;

/**
 * 闲置物品图片dao层接口
 * @author TTWen 2017.6.19
 *
 */

public interface IIdlefDAO {

	//按照闲置物品图片id查找
	public Object findById(String idlefid) throws Exception;
	
	//按照闲置物品id查找其所有闲置物品图片
	public List<Object> findByIdle(String idleid)throws Exception;
	
	//查找全部闲置物品图片
	public List<Object> findAllIdlef()throws Exception;
 	
 	//为一个闲置物品添加一个闲置物品图片
 	public boolean addIdlef(IdleFile idlefile) throws Exception;
 	
 	//删除一个闲置物品的图片
 	public boolean deleteIdlef(String idlefid)throws Exception;
 	
 	//删除 一个闲置物品的所有图片
 	public boolean deleteIdlefs(String idleid) throws Exception;
}
