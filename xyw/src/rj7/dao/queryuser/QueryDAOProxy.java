package rj7.dao.queryuser;
import java.util.ArrayList;
import rj7.bean.Member;
/**
 * 查询好友代理类
 * 
 * @author 娄梦慧
 * 
 */
public class QueryDAOProxy implements IQueryDAO{
	QueryDAOImpl dao = new QueryDAOImpl();
	/**
	 * 查询好友
	 * 
	 * @author 娄梦慧
	 * @param Member
	 * @return 符合要求好友列表
	 */
	public ArrayList <Member> queryUser(Member member,int age1,int age2){
		ArrayList<Member> user=new ArrayList<Member>();
		user = null;
		try{
			user = dao.queryUser(member,age1,age2);
		}
		catch(Exception e)
		{
			throw e; 
		}
		return user;
	}

}
