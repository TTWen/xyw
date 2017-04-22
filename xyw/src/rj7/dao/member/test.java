package rj7.dao.member;

import rj7.bean.Member;
import rj7.util.DAOFactory;


public class test {

	public static void main(String[] args) {
		String id = "1";
		String pswd = "123";
		Member mem = (Member)DAOFactory.getDaoInstance().findById("tblUser", id, Member.class);
		System.out.println(mem.getPswd());
		System.out.println(DAOFactory.getDaoInstance().login(id, pswd, "tblUser"));
	}
}
