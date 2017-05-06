package rj7.dao.attention;

import java.util.ArrayList;

import rj7.bean.Attention;

public interface IAttentionDAO {
	 public boolean AttentionUser(Attention atten) throws Exception; //关注好友
	 public boolean UnAttentionUser(Attention atten) throws Exception;//取消关注
	 public ArrayList <Attention> findById(String userid) throws Exception;//查询已被关注的好友
}
