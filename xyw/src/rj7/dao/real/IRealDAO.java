package rj7.dao.real;



import rj7.bean.Real;

public interface IRealDAO {
	public Real findById(String id, String tblname,String idname);//通过ID获得数据
	public int insertReal(Real real);//插入数据
	public int deleteReal(String id);//删除数据
	public int editReal(Real real);//修改
	
	
 
}
//