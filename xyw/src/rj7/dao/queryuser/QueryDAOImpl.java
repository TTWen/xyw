package rj7.dao.queryuser;
import java.util.ArrayList;
import java.util.List;
import rj7.bean.Member;
import rj7.util.Connect;
/**
 * 查询好友实现类
 * 
 * @author 娄梦慧
 * 
 */
public class QueryDAOImpl implements IQueryDAO{
	/**
	 * 查询好友
	 * 
	 * @author 娄梦慧
	 * @param Member
	 * @return 符合要求好友列表
	 */
	 public ArrayList <Member> QueryUser(Member member){
		 boolean flag=false;
	    Connect conn=Connect.getInstance();
	 	String sql = "select username,iconurl from tblMember,tblMemberDetail"
	 			+ "where tblMember.id = tblMemberDetail.id AND tblMember.username like '%?%' AND tblMember.sex = ? "
	 			+ "AND tblMember.age <= ? AND tblMember.age >= ? AND tblMember.city = ?";
	 	ArrayList<Member> user=new ArrayList<Member>();
	 	List<Object> param=new ArrayList<Object>();
	 	param.add(member.getUsername());
	 	param.add(member.getSex());
	 	param.add(member.getAge());
	 	param.add(member.getAge());
	 	param.add(member.getCity());
	 	user=(ArrayList)conn.queryForArrObject(sql, param, Member.class);
	 	return user;
	 }
}
