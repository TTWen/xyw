package rj7.dao.queryuser;

import java.util.ArrayList;

import rj7.bean.Member;
/**
 * 查询好友接口
 * 
 * @author 娄梦慧
 * 
 */
public interface IQueryDAO {
	public ArrayList <Member> QueryUser(Member member);//查询好友
}
