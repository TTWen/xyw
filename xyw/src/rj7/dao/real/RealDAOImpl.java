package rj7.dao.real;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import rj7.bean.Real;
import rj7.bean.Tuisong;
import rj7.util.Connect;
import rj7.util.DAOFactory;
/**
 * 实名认证Real的DAO
 * @author 史国梅  2017.5.8
 *
 */
public class RealDAOImpl implements IRealDAO {
	
//  通过ID获得数据	
	public Real findById(String id, String tblname,String idname)
	{
		return (Real)DAOFactory.getDaoInstance().findById(tblname, id,  Real.class,idname);
	}

//  按照ris查找,查询所有没有通过审核的用户
	public List<Object> findByris(String ris){
		Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select rid idcard,name,filesurl,iconurl,adress,post,school,major,qq"
					+ " from tblreal where ris = ?";
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(ris);
			return  conn.queryForArrObject(sql, param,Real.class);//以List<Object>形式返回
		}
	
//	实名认证通过时插入数据
	public int insertReal(Real real){
		String sql = "INSERT INTO tblreal(rid,idcard,name,iconurl,adress,post,creatime) VALUES(?,?,?,?,?,?,?)";
			Connect conn = Connect.getInstance();
			List<Object> param = new ArrayList<Object>();
			Date date=new Date();				//获取系统时间并进行格式化
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
            real.setCreatime(time);
			param.add(real.getRid());
			param.add(real.getIdcard());
			param.add(real.getName());
			param.add(real.getIconurl());
			param.add(real.getAdress());
			param.add(real.getPost());
			param.add(real.getCreatime());
			return conn.update(sql, param);
		}

//  学生身份认证插入的数据
	public int insertRealstu(Real real){
		String sql = "update tblreal set school=?,major=?,qq=?,ris=? where rid= ?";
		Connect conn = Connect.getInstance();
		List<Object> param = new ArrayList<Object>();
		param.add(real.getSchool());
		param.add(real.getMajor());
		param.add(real.getQq());
		param.add(real.getRis());
		param.add(real.getRid());
		return conn.update(sql, param);
	}
	
//	删除
	public int deleteReal(String id){
		String sql = "delete from tblreal where rid = ?";
		Connect conn = Connect.getInstance();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		return conn.update(sql, param);
	}
	
//  审核通过更新ris
	public int  editRis(String rid){
		String sql = "update tblreal set ris=? where rid = ?";
		Connect conn = Connect.getInstance();
		List<Object> param = new ArrayList<Object>();
		param.add("1");
		param.add(rid);
		return conn.update(sql, param);
	}

//  修改
	public int editReal(Real real){
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
	
 

