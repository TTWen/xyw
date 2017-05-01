package rj7.dao.coin;

import rj7.bean.Coin;

public interface ICoinDAO {
	 public boolean CoinUser(Coin coin) throws Exception; 
	 public boolean UnCoinUser(Coin coin) throws Exception;
}
