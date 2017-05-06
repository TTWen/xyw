package rj7.util;

import rj7.dao.attention.AttentionDAOProxy;
import rj7.dao.attention.IAttentionDAO;
import rj7.dao.chat.ChatDAOProxy;
import rj7.dao.chat.IChatDAO;
import rj7.dao.idle.IIdleDAO;
import rj7.dao.idle.IdleDAOProxy;
import rj7.dao.member.IMemberDAO;
import rj7.dao.member.MemberDAOProxy;
import rj7.dao.queryuser.IQueryDAO;
import rj7.dao.queryuser.QueryDAOProxy;
import rj7.dao.real.IRealDAO;
import rj7.dao.real.RealDAOProxy;

public class DAOFactory {

	public static DAO getDaoInstance() {
		return new DAO();
	}
	
	// 获取闲置物dao实例
	public static IIdleDAO getIIdleDaoInstance() throws Exception {
		return new IdleDAOProxy();
	}
	
	// 获取关注dao实例
	public static IAttentionDAO getIAttentionDAOInstance() throws Exception {
		return new AttentionDAOProxy();
	}
	
	// 获取会员dao实例
	public static IMemberDAO getIMemberDAOInstance() throws Exception {
		return new MemberDAOProxy();
	}
	
	// 获取聊天dao实例
	public static IChatDAO getIChatDAOInstance() throws Exception {
		return new ChatDAOProxy();
	}
	
	// 获取聊天dao实例
//	public static IMemberDetailDAO getIMemberDetailDAOInstance() throws Exception {
//		return new MemberDetailDAOProxy();
//	}
	
	// 获取查询dao实例
	public static IQueryDAO getIQueryDAOInstance() throws Exception {
		return new QueryDAOProxy();
	}
	
	// 获取实名dao实例
	public static IRealDAO getIRealDAOInstance() throws Exception {
		return new RealDAOProxy();
	}
	
	// 获取推送dao实例
//	public static IRealDAO getIRealDAOInstance() throws Exception {
//		return new RealDAOProxy();
//	}	
}
