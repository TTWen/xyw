package rj7.dao.real;


import java.util.List;

import rj7.bean.Real;
import rj7.bean.Tuisong;
import rj7.util.DAOFactory;


/**
 * @author 史国梅
 *
 */
public class Test {
	public static void main(String[] args) {
		RealDAOProxy proxy= new RealDAOProxy();
		String id ="2";
		String idname="rid";
		Real real = (Real)DAOFactory.getDaoInstance().findById("tblreal", id, Real.class,idname);
		
		System.out.println(real.getAdress());
		System.out.println(real.getFilesurl());
		System.out.println(real.getIdcard());
		System.out.println(real.getRid());
		
		//修改表
//		real.setAdress("shiguomei");
//		proxy.editReal(real);
//		Real real2 = (Real)DAOFactory.getDaoInstance().findById("tblreal", id, idtype, Real.class);
//		System.out.println(real.getAdress());
//		System.out.println(real2.getAdress());
//		System.out.println(real2.getFilesurl());
//		System.out.println(real2.getIdcard());
//		System.out.println(real2.getRid());
		
		
		//删除表
//		proxy.deleteReal("3");
//      插入表
//				Real real1 = new Real();
//				real1.setRid("5");
//				real1.setIdcard("1234567890");
//				proxy.insertReal(real1);
//				System.out.println(real1.getAdress());
//				System.out.println(real1.getFilesurl());
//				System.out.println(real1.getIdcard());
//				System.out.println(real1.getRid());
		
//      按照ris
		List list0 = proxy.findByris("1");
		for(Object t1:list0){
			Real t2 = (Real)t1;
			System.out.println(t2.getRid()+" "+t2.getAdress()+" "+t2.getSchool());
		}
		
//      修改学生认证信息
//		Real r1=new Real();
//		r1.setRid("3");
//		r1.setSchool("3");
//		r1.setMajor("3");
//		proxy.insertRealstu(r1);

//      审核学生信息通过没有
		String rid="8";
		proxy.editRis(rid);
		
		
	}
}
