package rj7.dao.user;

import org.apache.catalina.User;

public interface IUserDAO {

	public User findById(String id, String tblname);
	
}
