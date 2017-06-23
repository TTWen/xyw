package rj7.dao.attention;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Attention;
import rj7.bean.Member;
import rj7.bean.MemberDetail;
import rj7.util.Connect;
import rj7.util.DAO;
/**
 * 关注好友实现类
 * 
 * @author 娄梦慧
 * 
 */
public class AttentionDAOImpl implements IAttentionDAO{
	/**
	 * 关注好友
	 * 
	 * @author 娄梦慧
	 * @param Attention
	 * @return 关注好友结果（成功：true，失败:false）
	 */
     public boolean AttentionUser(Attention atten){
        boolean flag=false;
    	Connect conn=Connect.getInstance();
 		String sql = "insert into tblatten (userid,attenid,attentime) values (?,?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'))";
 		ArrayList param=new ArrayList();
 	 	param.add(atten.getUserid());
 		param.add(atten.getAttenid());
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
     
     /**
 	 * 取消关注好友
 	 * 
 	 * @author 娄梦慧
 	 * @param Attention
 	 * @return 取消关注好友结果（成功：true，失败:false）
 	 */
     public boolean UnAttentionUser(Attention atten){
    	 boolean flag=false;
     	Connect conn=Connect.getInstance();
     	String sql = "delete from tblatten where userid = ? && attenid = ?";
     	List<Object> param = new ArrayList<Object>();
		param.add(atten.getUserid());
        param.add(atten.getAttenid());
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
    
     /**
  	 *  查询已关注的好友
  	 * 
  	 * @author 娄梦慧
  	 * @param userid
  	 * @return 已关注好友列表
  	 */
     public ArrayList<Object> hasAtten(String userid){
      	Connect conn = Connect.getInstance();
   		String sql1 = "select attenid from tblatten where userid = ?";
   		List<Object> param1 = new ArrayList<Object>();
  		param1.add(userid);
  		List<Object> rs = conn.queryForArrObject(sql1, param1, Attention.class);
  		ArrayList<Object> list = new ArrayList<Object>();
  		for(int i=0;i<rs.size();i++){
  		  Attention atten = (Attention)rs.get(i);
   		  String sql2 = "select username,id from tbluser where id = ?";
   		  List<Object> param2 = new ArrayList<Object>();
   		  String id1 = atten.getAttenid();
   		  param2.add(id1);
   		  List<Object> mem1 = conn.queryForArrObject(sql2, param2, Member.class);
   		  Member member =(Member)mem1.get(0);
   		  list.add(member);
  		}
  		return list;
   	}
     /**
   	 *  查询粉丝
   	 * 
   	 * @author 娄梦慧
   	 * @param userid
   	 * @return 粉丝列表
   	 */
     public ArrayList<Object> hasBeenAtten(String attenid){
     	Connect conn = Connect.getInstance();
  		String sql1 = "select userid from tblatten where attenid = ?";
  		List<Object> param1 = new ArrayList<Object>();
 		param1.add(attenid);
 		List<Object> rs = conn.queryForArrObject(sql1, param1, Attention.class);
 		ArrayList<Object> list = new ArrayList<Object>();
 		for(int i=0;i<rs.size();i++){
 		  Attention atten = (Attention)rs.get(i);
  		  String sql2 = "select username,id from tbluser where id = ?";
  		  List<Object> param2 = new ArrayList<Object>();
  		  String id1 = atten.getUserid();
  		  param2.add(id1);
  		  List<Object> mem1 = conn.queryForArrObject(sql2, param2, Member.class);
  		  Member member =(Member)mem1.get(0);
  		  list.add(member);
 		}
 		return list;
  	}
     
     /**
   	 *   查询关注量
   	 * 
   	 * @author 娄梦慧
   	 * @param userid
   	 * @return 关注数
   	 */
     public int AttenCount (String userid){
    	 Connect conn=Connect.getInstance();
 		int count;
 		String sql="select count(*) from tblatten where userid = ?";
 		List<Object> param1 = new ArrayList<Object>();
 		List<Object> param2 = new ArrayList<Object>();
  		param1.add(userid);
 		count=conn.count(sql, param1);
 		String sql2="update tblmemberdetail set coincount = ? where id = ?";
 		param2.add(String.valueOf(count));
 		param2.add(userid);
 		conn.update(sql2,param2);
 		return count;
     }
     
     /**
    	 *   查询粉丝量
    	 * 
    	 * @author 娄梦慧
    	 * @param userid
    	 * @return 粉丝数
    	 */
     public int FansCount (String attenid){
    	 Connect conn=Connect.getInstance();
 		int count;
 		String sql="select count(*) from tblatten where attenid = ?";
 		List<Object> param1 = new ArrayList<Object>();
 		List<Object> param2 = new ArrayList<Object>();
  		param1.add(attenid);
 		count=conn.count(sql, param1);
 		String sql2="update tblmemberdetail set fanscount = ? where id = ?";
 		param2.add(String.valueOf(count));
 		param2.add(attenid);
 		conn.update(sql2,param2);
 		return count;
     }
}
