package rj7.dao.queryuser;
import java.util.ArrayList;
import java.util.List;

import rj7.bean.Member;
import rj7.bean.MemberDetail;
import rj7.bean.User;
import rj7.util.Connect;

public class QueryDAOImpl implements IQueryDAO{
	//≤È—Ø∫√”—
	 public ArrayList <MemberDetail> QueryUser(MemberDetail member) throws Exception{
		 boolean flag=false;
	    Connect conn=Connect.getInstance();
	 	String sql ="select username,userage,iconurl from tblMemberDetail "
	 			+ "where username like '%?%' && usersex = ? "
	 			+ "&& userage <= ? && userage >= ? && city = ?";
	 	ArrayList<MemberDetail> user=new ArrayList<MemberDetail>();
	 	List<Object> param=new ArrayList<Object>();
	 	param.add(member.getUsername());
	 	param.add(member.getUsersex());
	 	param.add(member.getUserage());
	 	param.add(member.getUserage());
	 	param.add(member.getCity());
	 	user=(ArrayList)conn.queryForArrObject(sql, param, MemberDetail.class);
	 	return user;
	 }
}
