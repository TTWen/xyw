package rj7.dao.coin;

import java.util.ArrayList;

import dbc.DatabaseConnection;

import rj7.bean.Coin;
import rj7.util.Connect;

public class CoinDAOProxy implements ICoinDAO{
	Connect conn = Connect.getInstance();
	CoinDAOImpl dao = new CoinDAOImpl();
	//关注好友
	 public boolean CoinUser(Coin coin) throws Exception{
		
		 boolean flag=false;
		 try
		 { 
			flag=dao.CoinUser(coin); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 //取消关注
	 public boolean UnCoinUser(Coin coin) throws Exception{
		 boolean flag=false;
		 try
		 { 
			flag=dao.UnCoinUser(coin); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 //查询所有已关注的好友
	 public ArrayList <Coin> findById(String userid) throws Exception{
		 ArrayList<Coin> coin = new ArrayList<Coin>();
		 try
		 { 
			coin = dao.findById(userid); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return coin;
	 }
}
