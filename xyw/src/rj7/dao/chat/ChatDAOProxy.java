package rj7.dao.chat;

import rj7.bean.Chat;
import rj7.util.Connect;

public class ChatDAOProxy implements IChatDAO{
	Connect conn = Connect.getInstance();
	ChatDAOImpl dao = new ChatDAOImpl();
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
}
