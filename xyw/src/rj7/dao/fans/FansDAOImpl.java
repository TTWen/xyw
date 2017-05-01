package rj7.dao.fans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Coin;
import rj7.bean.Fans;
import rj7.dao.fans.IFansDAO;
import rj7.util.Connect;

public class FansDAOImpl implements IFansDAO{
	//被好友关注
	public boolean FansUser(Fans fans) throws Exception{
	        boolean flag=false;
	    	Connect conn=Connect.getInstance();
	 		String sql = "insert into tblfans (countid,userid,fansid,fanstime)"
	 				+ "values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'))";
	 		ArrayList param=new ArrayList();
	 		param.add(fans.getCountid());
	 	 	param.add(fans.getUserid());
	 		param.add(fans.getFansid());
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
	
	//被好友取消关注
	 public boolean UnFansUser(Fans fans) throws Exception{
		 boolean flag=false;
	     	Connect conn=Connect.getInstance();
	     	String sql = "delete from tblfans where userid = ? && fansid = ?";
	     	List<Object> param = new ArrayList<Object>();
			param.add(fans.getUserid());
	        param.add(fans.getFansid());
	        int result = conn.update(sql, param);
	        if(result>0){
	 			flag = true;
	 		}
	 		return flag;
	 }
	 
	//查询所有粉丝
     public ArrayList <Fans> findById(String userid) throws Exception{
 		String sql = "select username,userage,iconurl from tblMemberDetail"
 				+ "where id = (select fansid from tblcoin where userid = ?)";
 		Connect conn = Connect.getInstance();
 		List<Object> param = new ArrayList<Object>();
 		param.add(userid);
 		//将查询结果封装到javabean中
 		ArrayList<Fans> fans = (ArrayList)conn.queryForArrObject(sql, param, Fans.class);
 		return fans;
 	}
}
