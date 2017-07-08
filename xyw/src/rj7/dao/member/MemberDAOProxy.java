package rj7.dao.member;

import rj7.bean.Member;

/**
 * 会员dao层代理类
 * @author 梁爽爽
 */

public class MemberDAOProxy implements IMemberDAO {

	private IMemberDAO dao = null;
	
	public MemberDAOProxy() {
		
		this.dao = new MemberDAOImpl();
	}

	public boolean modifyInfo(Member mem) {
		if( dao.modifyInfo(mem) ) return true;
		return false;
	}
	
	
}
