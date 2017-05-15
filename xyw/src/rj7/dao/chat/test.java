package rj7.dao.chat;

import java.util.ArrayList;

import rj7.bean.Chat;
import rj7.util.DAOFactory;

public class test {

	public static void main(String[] args){
		/*Chat chat = new Chat();
		chat.setMessages("你好呀");
		chat.setFromuserid("1003");
		chat.setTouserid("1001");
		chat.setMsgtype("文字");
		try
		{ 
			if(DAOFactory.getIChatDAOInstance().ChatUser(chat))
			{
				System.out.println("成功啦");
			}
			else{
				System.out.println("失败啦");
			}
			
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}*/
		
		/*try
		{ 
			if(DAOFactory.getIChatDAOInstance().DsdeChatUser())
			{
				System.out.println("成功啦");
			}
			else{
				System.out.println("失败啦");
			}
			
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}*/
		/*try
		{ 
			if(DAOFactory.getIChatDAOInstance().SddeChatUser("7"))
			{
				System.out.println("成功啦");
			}
			else{
				System.out.println("失败啦");
			}
			
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}*/
		/*ArrayList<Chat> list = new ArrayList<Chat>();
		try{
			list = DAOFactory.getIChatDAOInstance().find(1001,1002);
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).getMessageid());
			}
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}*/
		Chat chat = new Chat();
		ArrayList<Chat> list = new ArrayList<Chat>();
		
		chat.setMessages("好");
		chat.setSendtime("2016/5/14");
		chat.setFromuserid("1001");
		chat.setTouserid("1002");
		try
		{ 
			list = DAOFactory.getIChatDAOInstance().queryRecord(chat);
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).getMessages());
			}
			
		}
		catch (Exception e)
		 
		{
			e.printStackTrace(); 
		}
		
	}
		

}
