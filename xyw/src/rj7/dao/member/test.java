package rj7.dao.member;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import rj7.bean.Member;
import rj7.util.DAO;
import rj7.util.DAOFactory;


public class test {

	static DAO dao = DAOFactory.getDaoInstance();
	
	public static void main(String[] args) {
		Member mem = new Member();
//		System.out.println(dao.modigypswd("tbluser", "123456", "1"));
//		List<Object> li = dao.pageQuery("tbluser", Member.class, 0, 5, "where id > 40 order by id desc");
//		int lisize = li.size();
//		for(int i = 0; i< lisize; i++) {
//			mem = (Member) li.get(i);
//			System.out.println("member"+ mem.getId());
//		}
		
//		测试modifyinfo
//		mem.setId("1");
//		mem.setBirth("1996/08/12");
//		mem.setCity("beijing");
//		mem.setAge("21");
//		mem.setSex("女");
//		IMemberDAO memdao;
//		try {
//			memdao = DAOFactory.getIMemberDAOInstance();
//			memdao.modifyInfo(mem);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String s = new String("123");  
        System.out.println("原始：" + s); 
        System.out.println("MD5后：" + dao.md5(s));  
        System.out.println("加密的：" + dao.convertMD5(s));  
        System.out.println("解密的：" + dao.convertMD5(dao.convertMD5(s)));
	}
}
