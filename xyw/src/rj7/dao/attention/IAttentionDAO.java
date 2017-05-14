package rj7.dao.attention;

import java.util.ArrayList;

import rj7.bean.Attention;
import rj7.bean.Member;
/**
 * 关注好友接口
 * 
 * @author 娄梦慧
 * 
 */
public interface IAttentionDAO {
	 public boolean AttentionUser(Attention atten) ; //关注好友
	 
	 public boolean UnAttentionUser(Attention atten) ;//取消关注好友
	 
     public ArrayList <Object> hasAtten(String userid);//查询已关注好友
   
     public ArrayList <Object> hasBeenAtten(String attenid);//查询粉丝
     
     public int AttenCount (String userid);//查询关注量
     
     public int FansCount (String attenid);//查询粉丝量
}
