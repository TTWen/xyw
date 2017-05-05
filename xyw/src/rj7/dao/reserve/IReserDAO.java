package rj7.dao.reserve;
import rj7.bean.Reserve;
import java.util.List;
public interface IReserDAO {
		//预约接口
		
		public boolean doCreate(Reserve r)throws Exception;//创建预约
		public boolean doDelete(String r)throws Exception;//删除预约
		public boolean doUpdate(Reserve r)throws Exception;//更新预约
		public List<Object> findAll()throws Exception;//查找所有预约
	    public Object findByid(String id, String tblname,String idname)throws Exception;	//按照预约id查找
		public List<Object> findByuserid(String userid) throws Exception;//按照用户id查找
		public List<Object> findBycity(String resercity) throws Exception;//按照预约城市查找
	 
	}
