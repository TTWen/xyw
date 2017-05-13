package rj7.util;

import java.util.ArrayList;
import java.util.List;

public class DAO {

	private static Connect conn = Connect.getInstance();
	
	/**
	 * 按照表的主键查找该对象
	 * @param tblname 表名
	 * @param id 表的主键
	 * @param cls 如 Member.class 
	 * @return 返回对应的javabean对象
	 * @author 梁爽爽  2017.4.23 
	 * @update 2017.5.6  list下标越界处理
	 */
	public Object findById(String tblname, String id, Class<?> cls, String idname) {
		String sql = "select * from "+ tblname +" where "+ idname +" = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Object> rs = conn.queryForArrObject(sql, param, cls);
		if(rs.isEmpty()) return null;
		return rs.get(0);
	}
	
	/**
	 * 用户、管理员登录或账号密码验证
	 * @param username
	 * @param pswd
	 * @param tblname
	 * @return 登录成功返回1，失败返回0
	 * @author 梁爽爽   2017.4.22
	 */
	public int login(String username, String pswd, String tblname) {
		String sql = "select count(1) from "+ tblname +" where username=? and pswd=?";
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(pswd);
		return conn.count(sql, param);
	}
	
	/**
	 * 用户、管理员注册
	 * @param username
	 * @param pswd
	 * @param tblname
	 * @return 注册成功返回1，失败返回0
	 * @author 梁爽爽 2017.4.30
	 */
	public int regist(String username, String pswd, String tblname, String email) {
		
		String sql = "insert into "+ tblname +" (id, username, pswd, email) values (null,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(pswd);
		param.add(email);
		return conn.update(sql, param);
	}
}
