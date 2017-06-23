package rj7.dao.real;


import java.util.List;

import rj7.bean.Real;

import rj7.util.DAOFactory;


/**
 * @author 史国梅
 *
 */
public class Test {
	public static void main(String[] args) {
		RealDAOProxy proxy= new RealDAOProxy();
//		String id ="20";
//		String idname="rid";
//		Real real = (Real)DAOFactory.getDaoInstance().findById("tblreal", id, Real.class,idname);
//		
//		System.out.println(real.getAdress());
//		System.out.println(real.getUserid());
//		System.out.println(real.getIdcard());
//		System.out.println(real.getRid());
		
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
				Real real2 = new Real();
//				real1.setIdcard("1234567890");
//				real1.setUserid("91");
//				real1.setAdress("是");
//				real1.setName("史国梅");
//				int b=proxy.insertReal(real1);
//				real2=(Real)proxy.findByuserid("91");
//				System.out.println(b);
//				System.out.println(real1.getUserid());
//				System.out.println(real1.getIdcard());
//				System.out.println(real1.getRid());
				real2.setUserid("123");
				real2.setSchool("郑大");
				int m=proxy.insertRealstu(real2);
				System.out.println(m);
		
//      按照ris
//		List list0 = proxy.findByris("1");
//		for(Object t1:list0){
//			Real t2 = (Real)t1;
//			System.out.println(t2.getRid()+" "+t2.getAdress()+" "+t2.getSchool());
//		}
//		
//      修改学生认证信息
//		Real r1=new Real();
//		r1.setRid("3");
//		r1.setSchool("3");
//		r1.setMajor("3");
//		proxy.insertRealstu(r1);

//      审核学生信息通过没有
//		String rid="8";
//		proxy.editRis(rid);
//		
		
	}
}
