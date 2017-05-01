package rj7.dao.fans;

import rj7.bean.Fans;
import rj7.dao.fans.FansDAOImpl;
import rj7.util.Connect;

public class FansDAOProxy implements IFansDAO{
	Connect conn = Connect.getInstance();
	FansDAOImpl dao = new FansDAOImpl();
	public boolean FansUser(Fans fans) throws Exception{
		
		 boolean flag=false;
		 try
		 { 
			flag=dao.FansUser(fans); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	public boolean UnFansUser(Fans fans) throws Exception{
		 boolean flag=false;
		 try
		 { 
			 flag=dao.UnFansUser(fans);  
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
}
