package rj7.dao.attention;

import java.util.ArrayList;

import rj7.bean.Attention;
import rj7.bean.Member;
import rj7.bean.MemberDetail;
import rj7.util.DAO;
import rj7.util.DAOFactory;

public class test {

	public static void main(String[] args){
	   ArrayList<Object> mem= new ArrayList<Object>();
		int count;
		  try
			{ 
			    MemberDetail member2 = new MemberDetail();
			    DAO d = new DAO();
			    String tbl = "tblmemberdetail";
			    String idname = "id";
				mem = DAOFactory.getIAttentionDAOInstance().hasAtten("1002");
				for(int i=0;i<mem.size();i++)
				{
					String id1 = ((Member)mem.get(i)).getId();		
					System.out.println(((Member) mem.get(i)).getUsername()); 
					member2 = (MemberDetail) d.findById(tbl, id1, MemberDetail.class, idname);
					System.out.println(member2.getIconurl());
							
				}
			  /*count = DAOFactory.getIAttentionDAOInstance().AttenCount("1002");
			  System.out.println(count);*/
				
			}
			catch (Exception e)
			 
			{
				e.printStackTrace(); 
			}
	}
}
