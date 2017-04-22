package rj7.dao.member;

import rj7.bean.Member;
import rj7.util.DAOFactory;

public class MemberDAOImpl implements IMemberDAO {

	public Member findById(String id, String tblname) {
		return (Member)DAOFactory.getDaoInstance().findById(tblname, id, Member.class);
	}

}
