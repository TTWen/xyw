package rj7.dao.member;

import rj7.bean.Member;

/**
 * 会员dao层接口
 * @author 梁爽爽  2017.4.22
 * 
 */
public interface IMemberDAO {

	public Member findById(String id, String tblname);
}
