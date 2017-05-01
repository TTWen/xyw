package rj7.dao.queryuser;
import java.util.ArrayList;
import rj7.bean.MemberDetail;
import rj7.util.Connect;

public class QueryDAOProxy implements IQueryDAO{
	Connect conn = Connect.getInstance();
	QueryDAOImpl dao = new QueryDAOImpl();
	public ArrayList <MemberDetail> QueryUser(MemberDetail member) throws Exception{
		ArrayList<MemberDetail> user=new ArrayList<MemberDetail>();
		user = null;
		try{
			user = dao.QueryUser(member);
		}
		catch(Exception e)
		{
			throw e; 
		}
		return user;
	}

}
