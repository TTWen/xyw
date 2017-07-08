package rj7.dao.member;

import java.util.ArrayList;
import java.util.List;

import rj7.bean.Member;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * 会员dao层接口实现
 * @author 梁爽爽
 */

public class MemberDAOImpl implements IMemberDAO {

	private static Connect conn = Connect.getInstance();

	/**
	 * 修改用户信息：出生日期、年龄、现居城市、性别
	 * @param mem对象
	 * @return 修改成功返回true
	 * @since 2017/05/18
	 */
	public boolean modifyInfo(Member mem) {
		List<Object> param = new ArrayList<Object>();
		String sql = null;
		param.add(mem.getBirth());
		param.add(mem.getAge());
		param.add(mem.getCity());
		param.add(mem.getSex());
		param.add(mem.getSignature());
		param.add(mem.getId());
		sql = "update tbluser set birth = ?, age = ?, city = ?, sex = ?, "
				+ "signature = ? where id = ?";
		if(conn.update(sql, param) == 1) return true;
		return false;
	}

}
