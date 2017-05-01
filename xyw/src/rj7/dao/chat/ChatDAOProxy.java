package rj7.dao.chat;

import rj7.bean.Chat;
import rj7.util.Connect;

public class ChatDAOProxy implements IChatDAO{
	Connect conn = Connect.getInstance();
	ChatDAOImpl dao = new ChatDAOImpl();
	//和好友聊天
	public boolean ChatUser(Chat chat) throws Exception{
		boolean flag=false;
		 try
		 { 
			flag=dao.ChatUser(chat);
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	//定时删除消息
	public boolean DsdeChatUser(Chat chat) throws Exception{
		boolean flag=false;
		 try
		 { 
			flag=dao.DsdeChatUser(chat);
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	//删除特定的消息
	public boolean SddeChatUser(Chat chat) throws Exception{
		boolean flag=false;
		 try
		 { 
			flag=dao.SddeChatUser(chat);
		 }
		 catch(Exception e)
		 { throw e; }
		 return flag; 
	}
	
	//所有的聊天记录
    public Chat find(Chat chat) throws Exception{
    	Chat chat1 = new Chat();
		 Chat chat2 = new Chat();
		 try{
			 chat1 = dao.find(chat2);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 return chat1;
    }
	
	//按天查询聊天记录
	 public Chat findByDay(Chat chat) throws Exception{
		 Chat chat1 = new Chat();
		 Chat chat2 = new Chat();
		 try{
			 chat1 = dao.findByDay(chat2);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 return chat1;
	 }
	 
	//按关键字查询聊天记录
		 public Chat findByWord(Chat chat) throws Exception{
			 Chat chat1 = new Chat();
			 Chat chat2 = new Chat();
			 try{
				 chat1 = dao.findByWord(chat2);
			 }
			 catch(Exception e)
			 {
				 throw e;
			 }
			 return chat1;
		 }
}
