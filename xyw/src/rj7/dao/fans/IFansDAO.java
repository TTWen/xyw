package rj7.dao.fans;

import rj7.bean.Fans;

public interface IFansDAO {
	 public boolean FansUser(Fans fans) throws Exception; 
	 public boolean UnFansUser(Fans fans) throws Exception;
}

