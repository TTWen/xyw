package rj7.dao.member;

import rj7.bean.Member;

/**
 * 会员dao层接口
 * @author 梁爽爽  2017.4.22
 * 
 */
public interface IMemberDAO {
	/**
	 * 修改用户信息：出生日期、年龄、现居城市、性别、个性签名
	 * @param mem对象
	 * @return 修改成功返回true
	 */
	public boolean modifyInfo(Member mem);

}
