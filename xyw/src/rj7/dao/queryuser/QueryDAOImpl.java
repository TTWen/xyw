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
	 
	 public ArrayList<Member> queryUser(Member member, int age1, int age2){
		 Connect conn=Connect.getInstance();
		 String sql = "select id,username from tbluser where 1=1";
		 List<Object> param=new ArrayList<Object>();
		 if(member.getUsername()!=null)
		 {
			 sql=sql+" and username LIKE ?";
	         param.add("%"+member.getUsername()+"%");
		 }
		 if(member.getSex()!=null)
		 {
			 sql=sql+" and sex = ?";
			 param.add(member.getSex());
		 }
		 if(member.getCity()!=null)
		 {
			 sql=sql+" and city = ?";
			 param.add(member.getCity());
		 }
			 sql=sql+" and age >= ? and age <= ?";
			 param.add(String.valueOf(age1));
			 param.add(String.valueOf(age2));
		 ArrayList<Member> user=new ArrayList<Member>();
		 user=(ArrayList)conn.queryForArrObject(sql, param, Member.class);
		 return user;
	 }
}

