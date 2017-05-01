package rj7.dao.coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Coin;

import rj7.util.Connect;

public class CoinDAOImpl implements ICoinDAO{
	//关注好友
     public boolean CoinUser(Coin coin) throws Exception{
        boolean flag=false;
    	Connect conn=Connect.getInstance();
 		String sql = "insert into tblcoin (countid,userid,coinid,cointime)"
 				+ "values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'))";
 		ArrayList param=new ArrayList();
 		param.add(coin.getCoinid());
 	 	param.add(coin.getUserid());
 		param.add(coin.getCoinid());
 		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=format.format(date);
	    System.out.print(time); 
		param.add(time);
 		int result = conn.update(sql, param);
 		if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     //取消关注
     public boolean UnCoinUser(Coin coin) throws Exception{
    	 boolean flag=false;
     	Connect conn=Connect.getInstance();
     	String sql = "delete from tblcoin where userid = ? && coinid = ?";
     	List<Object> param = new ArrayList<Object>();
		param.add(coin.getUserid());
        param.add(coin.getCoinid());
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     //查询所有已关注的好友
     public Coin findById(String userid) throws Exception{
 		String sql = "select username,userage,iconurl from tblMemberDetail"
 				+ "where id = (select coinid from tblcoin where userid = ?)";
 		Connect conn = Connect.getInstance();
 		List<Object> param = new ArrayList<Object>();
 		param.add(userid);
 		//将查询结果封装到javabean中
 		ArrayList<Coin> coin = (ArrayList)conn.queryForArrObject(sql, param, Coin.class);
 		return coin.get(0);
 	}
}
