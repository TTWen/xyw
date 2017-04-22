package rj7.util;

import java.util.ArrayList;
import java.util.List;

public class DAO {

	private static Connect conn = Connect.getInstance();
	
	/**
	 * 按照表的主键查找该对象
	 * @param tblname 表名
	 * @param id 
	 * @param cls
	 * @return
	 */
	public Object findById(String tblname, String id, Class<?> cls) {
		String sql = "select * from "+ tblname +"where id = "+ id;
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Object> rs = conn.queryForArrObject(sql, param, cls);
		return rs.get(0);
	}
}
