package rj7.dao.real;


import java.util.List;

import rj7.bean.Real;




public class RealDAOProxy implements IRealDAO {
	
private IRealDAO dao = null;
	
	public RealDAOProxy() {
		
		this.dao = new RealDAOImpl();
	}
	
//  通过ID获得数据	
	public Real findById(String id, String tblname,String idname) {		
		return this.dao.findById(id, tblname,idname);
	}
	
//	插入实名认证的数据
	public int insertReal(Real real) {
		return this.dao.insertReal(real);
	}

//	删除
	public int deleteReal(String id) {
		return this.dao.deleteReal(id);
	}

//  修改
	public int editReal(Real real) {
		return this.dao.editReal(real);
	}
//	插入学生认证的数据
	public int insertRealstu(Real real){
		return this.dao.insertRealstu(real);
	}
	
//	按ris查找没有通过审核的用户
	public List<Object> findByris(String ris){
		return this.dao.findByris( ris);
	}
	
//  审核通过更新
	public int editRis(String rid) {
		return this.dao.editRis( rid);
	}
}
