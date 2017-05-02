package rj7.dao.real;



import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import rj7.bean.Real;
import rj7.util.Connect;
import rj7.util.DAOFactory;

public class RealDAOImpl implements IRealDAO {
    //通过ID获得数据	
	public Real findById(String id, String tblname,String idname)
	{
		return (Real)DAOFactory.getDaoInstance().findById(tblname, id,  Real.class,idname);
	}

	@Override
	public int insertReal(Real real) {
		String sql = "INSERT INTO tblreal(rid,idcard,name,filesurl,iconurl,adress,post,school,major,qq,ris) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			Connect conn = Connect.getInstance();
			List<Object> param = new ArrayList<Object>();

			param.add(real.getRid());
			param.add(real.getIdcard());
			param.add(real.getName());
			param.add(real.getFilesurl());
			param.add(real.getIconurl());
			param.add(real.getAdress());
			param.add(real.getPost());
			param.add(real.getSchool());
			param.add(real.getMajor());
			param.add(real.getQq());
			param.add(real.getRis());
			return conn.update(sql, param);
		}

	@Override
	public int deleteReal(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from tblreal where rid = ?";
		Connect conn = Connect.getInstance();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		return conn.update(sql, param);
	}

	@Override
	public int editReal(Real real) {
		// TODO Auto-generated method stub
		String sql = "update tblreal set idcard=?,name=?,filesurl=?,iconurl=?,adress=?,post=?,school=?,major=?,qq=?,ris=? where rid=?";
				Connect conn = Connect.getInstance();
				List<Object> param = new ArrayList<Object>();
				param.add(real.getIdcard());
				param.add(real.getName());
				param.add(real.getFilesurl());
				param.add(real.getIconurl());
				param.add(real.getAdress());
				param.add(real.getPost());
				param.add(real.getSchool());
				param.add(real.getMajor());
				param.add(real.getQq());
				param.add(real.getRis());
				param.add(real.getRid());
				return conn.update(sql, param);
	}
	
}
//
	
 

