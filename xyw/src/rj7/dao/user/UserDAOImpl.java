package rj7.dao.user;

import java.util.List;

import org.apache.catalina.User;

import rj7.util.DAO;
import rj7.util.DAOFactory;

public class UserDAOImpl implements IUserDAO {

	
	public User findById(String id, String tblname) {
		return (User)DAOFactory.getDaoInstance().findById(tblname, id, User.class);
	}

}
