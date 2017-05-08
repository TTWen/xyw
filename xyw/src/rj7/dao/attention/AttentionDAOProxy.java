package rj7.dao.attention;

import java.util.ArrayList;

import dbc.DatabaseConnection;

import rj7.bean.Attention;
import rj7.util.Connect;

public class AttentionDAOProxy implements IAttentionDAO{
	Connect conn = Connect.getInstance();
	AttentionDAOImpl dao = new AttentionDAOImpl();
	//关注好友
	 public boolean AttentionUser(Attention atten) throws Exception{
		
		 boolean flag=false;
		 try
		 { 
			flag=dao.AttentionUser(atten); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 //取消关注
	 public boolean UnAttentionUser(Attention atten) throws Exception{
		 boolean flag=false;
		 try
		 { 
			flag=dao.UnAttentionUser(atten); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 //查询所有已关注的好友
	 public ArrayList <Attention> findById(String userid) throws Exception{
		 ArrayList<Attention> atten = new ArrayList<Attention>();
		 try
		 { 
			 atten = dao.findById(userid); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return atten;
	 }
}
