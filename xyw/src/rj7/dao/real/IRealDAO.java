package rj7.dao.real;
import java.util.List;

import rj7.bean.Real;
/**
 * 实名认证Real的DAO
 * @author 史国梅  2017.5.8
 *
 */
public interface IRealDAO {
	public Real findById(String id, String tblname,String idname);//通过ID获得数据
	public int insertReal(Real real);//插入数据
	public int deleteReal(String id);//删除数据
	public int editReal(Real real);//修改
	public int insertRealstu(Real real);//插入学生数据
	public List<Object> findByris(String ris);//查询没有审核学生
	public int  editRis(String rid);//审核通过
	public List<Object> findPage(int pages, int limit, String ris);//分页查找
	public int recordNum(String keyword);//计算按ris查找的数量
	public List<Object> findByuserid(String userid);
 
}
//