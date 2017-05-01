package rj7.dao.coin;

import rj7.bean.Coin;

public interface ICoinDAO {
	 public boolean CoinUser(Coin coin) throws Exception; //关注好友
	 public boolean UnCoinUser(Coin coin) throws Exception;//取消关注
	 public Coin findById(String userid) throws Exception;//查询已被关注的好友
}
