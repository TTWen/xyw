package rj7.dao.attention;

import java.util.ArrayList;

import rj7.bean.Attention;
/**
 * 关注好友代理类
 * 
 * @author 娄梦慧
 * 
 */
public class AttentionDAOProxy implements IAttentionDAO{
	AttentionDAOImpl dao = new AttentionDAOImpl();
	/**
	 * 关注好友
	 * 
	 * @author 娄梦慧
	 * @param Attention
	 * @return 关注好友结果（成功：true，失败:false）
	 */
	 public boolean AttentionUser(Attention atten){
		
		 boolean flag=false;
		 try
		 { 
			flag=dao.AttentionUser(atten); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 /**
	 	 * 取消关注好友
	 	 * 
	 	 * @author 娄梦慧
	 	 * @param Attention
	 	 * @return 取消关注好友结果（成功：true，失败:false）
	 	 */
	 public boolean UnAttentionUser(Attention atten) {
		 boolean flag=false;
		 try
		 { 
			flag=dao.UnAttentionUser(atten); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	 }
	 
	 /**
	  	 *  查询已关注的好友
	  	 * 
	  	 * @author 娄梦慧
	  	 * @param userid
	  	 * @return 已关注好友列表
	  	 */
	 public ArrayList <Attention> findByUserid(String userid) {
		 ArrayList<Attention> atten = new ArrayList<Attention>();
		 try
		 { 
			 atten = dao.findByUserid(userid); 
		 }
		 catch(Exception e)
		 { throw e; }
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
    	 ArrayList<Attention> atten = new ArrayList<Attention>();
		 try
		 { 
			 atten = dao.findByAttenid(attenid); 
		 }
		 catch(Exception e)
		 { throw e; }
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
    	 int count = 0;
		 try
		 { 
			count = dao.AttenCount(userid); 
		 }
		 catch(Exception e)
		 { throw e; }
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
    	 int count = 0;
		 try
		 { 
			count = dao.FansCount(attenid); 
		 }
		 catch(Exception e)
		 { throw e; }
		 return count; 
     }
}
