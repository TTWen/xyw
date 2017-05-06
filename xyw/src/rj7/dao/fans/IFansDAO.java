package rj7.dao.fans;

import java.util.ArrayList;
import rj7.bean.Fans;

public interface IFansDAO {
	 public boolean FansUser(Fans fans) throws Exception; //被好友关注
	 public boolean UnFansUser(Fans fans) throws Exception;//被好友取消关注
	 public ArrayList <Fans> findById(String userid) throws Exception;//查询所有粉丝
}

