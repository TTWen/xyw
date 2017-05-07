package rj7.dao.attention;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Attention;
import rj7.bean.MemberDetail;
import rj7.util.Connect;
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
     public ArrayList <Attention> findByUserid(String userid){
 		String sql = "select username,iconurl from tblMember,tblMemberDetail"
 				+ "where tblMemberDetail.id IN (select attenid from tblatten where userid = ?) AND tblMember.id = tblMemberDetail.id";
 		Connect conn = Connect.getInstance();
 		List<Object> param = new ArrayList<Object>();
 		param.add(userid);
 		ArrayList<Attention> atten = (ArrayList)conn.queryForArrObject(sql, param, Attention.class);
 		return atten;
 	}
    
     /**
   	 *  查询粉丝
   	 * 
   	 * @author 娄梦慧
   	 * @param userid
   	 * @return 粉丝列表
   	 */
     public ArrayList <Attention> findByAttenid(String attenid){
  		String sql = "select username,iconurl from tblMember,tblMemberDetail"
  				+ "where tblMemberDetail.id IN (select userid from tblatten where attenid = ?) AND tblMember.id = tblMemberDetail.id";
  		Connect conn = Connect.getInstance();
  		List<Object> param = new ArrayList<Object>();
  		param.add(attenid);
  		ArrayList<Attention> atten = (ArrayList)conn.queryForArrObject(sql, param, Attention.class);
  		return atten;
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
 		List<Object> param = new ArrayList<Object>();
  		param.add(userid);
 		count=conn.count(sql, param);
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
 		List<Object> param = new ArrayList<Object>();
  		param.add(attenid);
 		count=conn.count(sql, null);
 		return count;
     }
}
