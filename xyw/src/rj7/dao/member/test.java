package rj7.dao.member;

import java.util.List;

import rj7.bean.Member;
import rj7.util.DAO;
import rj7.util.DAOFactory;


public class test {

	static DAO dao = DAOFactory.getDaoInstance();
	public static void main(String[] args) {
		List<Object> li = dao.pageQuery("tbluser", Member.class, 0, 5, "where id > 40 order by id desc");
		int lisize = li.size();
		Member mem = null;
		for(int i = 0; i< lisize; i++) {
			mem = (Member) li.get(i);
			System.out.println("member"+ mem.getId());
		}
	}
}
