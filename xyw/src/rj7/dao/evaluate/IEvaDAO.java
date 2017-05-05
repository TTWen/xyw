package rj7.dao.evaluate;
import rj7.bean.Evaluate;
import rj7.bean.Reserve;
import java.util.List;
public interface IEvaDAO {
		//预约接口
		
		public boolean doCreate(Evaluate e)throws Exception;//创建评价
		public boolean doDelete(String id)throws Exception;//删除评价
		public boolean doUpdate(Evaluate e)throws Exception;//更新评价
		public List<Object> findAll()throws Exception;//查找所有评价
	    public Object findByid(String id, String tblname,String idname)throws Exception;	//按照评价id查找
		public List<Object> findByuserid(String userid) throws Exception;//按照用户id查找
		public List<Object> findBystar(String evastar) throws Exception;//按照星级数查找

	 
	}
