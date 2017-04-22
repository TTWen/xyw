package rj7.dao.member;

import rj7.bean.Member;

public interface IMemberDAO {

	public Member findById(String id, String tblname);
}
