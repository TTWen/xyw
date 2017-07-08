package rj7.dao.queryuser;
import java.util.ArrayList;

import rj7.bean.Member;
import rj7.bean.MemberDetail;
import rj7.util.DAO;
import rj7.util.DAOFactory;

public class test {
	public static void main(String[] args) {
		Member mem = new Member();
		ArrayList<Member> user=new ArrayList<Member>();
	
	
	    
	   int age1 = 0;
	   int age2 = 16;
	    try
		{ 
			user = DAOFactory.getIQueryDAOInstance().queryUser(mem,age1,age2); 
			int siz = user.size();
			MemberDetail member2 = new MemberDetail();
			DAO d = new DAO();
			String tbl = "tblmemberdetail";
			String idname = "id";
			for(int i=0;i<siz;i++)
			{
				Member member1 = user.get(i);
				System.out.println(member1.getUsername());
				String id1 = member1.getId();
				member2 = (MemberDetail) d.findById(tbl, id1, MemberDetail.class, idname);
				System.out.println(member2.getIcon());
			}
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}
	
	}
}
