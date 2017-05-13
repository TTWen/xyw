package rj7.dao.attention;

import java.util.ArrayList;

import dbc.DatabaseConnection;

import rj7.bean.Attention;
import rj7.util.Connect;

public class AttentionDAOProxy implements IAttentionDAO{
	Connect conn = Connect.getInstance();
	AttentionDAOImpl dao = new AttentionDAOImpl();
	//��ע����
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
	 
	 //ȡ����ע
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
	 
	 //��ѯ�����ѹ�ע�ĺ���
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
