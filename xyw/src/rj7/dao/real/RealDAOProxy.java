package rj7.dao.real;


import rj7.bean.Real;


public class RealDAOProxy implements IRealDAO {
	

private IRealDAO dao = null;
	
	public RealDAOProxy() {
		
		this.dao = new RealDAOImpl();
	}
	
    //通过ID获得数据	
	public Real findById(String id, String tblname,String idname) {
		
		return this.dao.findById(id, tblname,idname);
	}

	@Override
	public int insertReal(Real real) {
		// TODO Auto-generated method stub
		return this.dao.insertReal(real);
	}

	@Override
	public int deleteReal(String id) {
		// TODO Auto-generated method stub
		return this.dao.deleteReal(id);
	}

	@Override
	public int editReal(Real real) {
		// TODO Auto-generated method stub
		return this.dao.editReal(real);
	}
	
}
//