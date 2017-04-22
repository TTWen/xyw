package rj7.dao.member;

import rj7.bean.Member;
import rj7.util.DAOFactory;

/**
 * 会员dao层接口实现
 * @author 梁爽爽  2017.4.22
 *
 */
public class MemberDAOImpl implements IMemberDAO {

	public Member findById(String id, String tblname) {
		
		return (Member)DAOFactory.getDaoInstance().findById(tblname, id, Member.class);
	}

}
