package rj7.dao.member;

import rj7.bean.Member;

/**
 * 会员dao层代理类
 * @author 梁爽爽  2017.4.22
 *
 */
public class MemberDAOProxy implements IMemberDAO {

	private IMemberDAO dao = null;
	
	public MemberDAOProxy() {
		
		this.dao = new MemberDAOImpl();
	}
	
	public Member findById(String id, String tblname) {
		
		return this.dao.findById(id, tblname);
	}

	
}
