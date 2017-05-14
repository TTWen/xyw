package rj7.dao.chat;

import java.util.ArrayList;

import rj7.bean.Chat;
/**
 * 在线聊天代理类
 * 
 * @author 娄梦慧
 * 
 */
public class ChatDAOProxy implements IChatDAO{
	ChatDAOImpl dao = new ChatDAOImpl();
	/**
	 * 与好友聊天
	 * 
	 * @author 娄梦慧
	 * @param Chat
	 * @return 与好友聊天结果（成功：true，失败:false）
	 */
	public boolean ChatUser(Chat chat) throws Exception {
		boolean flag=false;
		 try
		 { 
			flag=dao.ChatUser(chat);
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	/**
	 * 定时删除消息
	 * 
	 * @author 娄梦慧
	 * @param Chat
	 * @return 定时删除消息结果（成功：true，失败:false）
	 */
	public boolean DsdeChatUser( ) {
		boolean flag=false;
		 try
		 { 
			flag=dao.DsdeChatUser();
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	/**
 	 * 手动删除消息
 	 * 
 	 * @author 娄梦慧
 	 * @param Chat
 	 * @return 手动删除消息结果（成功：true，失败:false）
 	 */
	public boolean SddeChatUser(String messageid) {
		boolean flag=false;
		 try
		 { 
			flag=dao.SddeChatUser(messageid);
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	 /**
  	 * 查消息记录
  	 * 
  	 * @author 娄梦慧
  	 * @param Chat
  	 * @return 聊天记录列表
  	 */
    public ArrayList<Chat> queryRecord(Chat chat) {
		 ArrayList<Chat> chat1 = new ArrayList<Chat>();
		 try{
			 chat1 = dao.queryRecord(chat);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 return chat1;
	 }
}
