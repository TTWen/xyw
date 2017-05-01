package rj7.dao.coin;

import dbc.DatabaseConnection;

import rj7.bean.Coin;
import rj7.util.Connect;

public class CoinDAOProxy implements ICoinDAO{
	Connect conn = Connect.getInstance();
	CoinDAOImpl dao = new CoinDAOImpl();
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
}
