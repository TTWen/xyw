package rj7.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	private static Connect conn = Connect.getInstance();
	
	/**
	 * 按照表的主键查找该对象
	 * @param tblname 表名
	 * @param id 表的主键
	 * @param cls 与数据库对应的javabean
	 * @return 返回对应的javabean对象，只返回唯一一个对象
	 * @author 梁爽爽  2017.4.23 
	 * @update 2017.5.6  list下标越界处理
	 */
	public Object findById(String tblname, String id, Class<?> cls, String idname) {
		String sql = "select * from "+ tblname +" where "+ idname +" = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Object> rs = conn.queryForArrObject(sql, param, cls);
		if( rs.isEmpty() ) return null;
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
	public boolean login(String username, String pswd, String tblname) {
		String sql = "select count(1) from "+ tblname
				+" where username=? and pswd=?";
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(pswd);
		if( conn.count(sql, param) == 0 ) return false;
		return true;
	}
	
	/**
	 * 用户、管理员注册
	 * @param username
	 * @param pswd
	 * @param tblname
	 * @return 注册成功返回true，失败返回false
	 * @author 梁爽爽 2017.4.30
	 */
	public boolean regist(String username, String pswd, String tblname, String email) {
		String sql = "insert into "+ tblname +" (id, username, pswd, email) "
				+ " values (null,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(pswd);
		param.add(email);
		if( conn.update(sql, param) == 0 ) return false;
		return true;
	}
	
	/**
	 * 用户、管理员修改密码,使用md5加密存储
	 * @param tblname 表名
	 * @param pswd 密码
	 * @param id 用户或管理员id
	 * @return 修改成功返回true
	 * @author 梁爽爽 2017.5.20
	 */
	public boolean modifypswd(String tblname, String pswd, String id) {
		pswd = md5(pswd);
		String sql = "update "+ tblname 
				+" set pswd = '" + pswd +"' where id = " +id;
		if( conn.update(sql, null) == 0 ) return false;
		return true;
	}
	
	/**
	 * md5加密，不可逆加密，用于数据校验
	 * @param inStr
	 * @return 返回加密后的数据
	 * @author 梁爽爽 2017.5.20
	 */
	public String md5(String inStr) {
		MessageDigest md5 = null;
		// 加盐
		inStr = inStr + "{*nbsjt*asar#cdxd#}";
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];
        
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }
        return hexValue.toString();
	}
	
	/**
	 * 加密、解密（除密码之外的数据使用该方法）
	 * convertMD5(s) 加密
	 * convertMD5(dao.convertMD5(s)) 解密
	 * @param inStr
	 * @return 返回加密或解密后的字符串
	 * @author 梁爽爽  2017.5.20
	 */
	public String convertMD5(String inStr){  
		
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ '*');
        }  
        String s = new String(a);  
        return s;
    }
	
	/**
	 * 分页查询
	 * @param tblname 要查询的表名
	 * @param cls 与数据库对应的javabean
	 * @param page 要查询的页数
	 * @param num 每页显示记录数
	 * @param criteria 查询条件：如 "where age < 19 and sex = '男' order by id"
	 * @return 一个列表，列表中存放的都是object对象
	 * @author 梁爽爽 2017.5.8
	 */
	public List<Object> pageQuery(String tblname, Class<?> cls,
			int page, int num, String criteria) {
		if(criteria == null) criteria = "";
		String sql = "select * from "+ tblname +" "+ criteria +" limit ?,?";
		List<Object> param = new ArrayList<Object>();
		param.add(page*num);
		param.add(num);
		return conn.queryForArrObject(sql, param, cls);
	}
}
