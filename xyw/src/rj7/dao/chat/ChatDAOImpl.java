package rj7.dao.chat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Chat;
import rj7.util.Connect;

public class ChatDAOImpl implements IChatDAO{
	Connect conn=Connect.getInstance();
	//与好友聊天
	public boolean ChatUser(Chat chat) throws Exception{
        boolean flag=false;
 		String sql = "insert into tblchat (messageid,messages,sendtime,fromuserid,touserid,mastype)"
 				+ "values (?,?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'),?,?,?)";
 		ArrayList param=new ArrayList();
 		param.add(chat.getMessageid());
 	 	param.add(chat.getMessages());
 		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=format.format(date);
	    System.out.print(time); 
		param.add(time);
		param.add(chat.getFromuserid());
		param.add(chat.getTouserid());
		param.add(chat.getMastype());
 		int result = conn.update(sql, param);
 		if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     public boolean DsdeChatUser(Chat chat) throws Exception{//定时删除消息
    	 boolean flag=false;
     	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=format.format(date);
     	String sql = "delete from tblchat where year(sendtime) = (year(?)-0.5)";
     	List<Object> param = new ArrayList<Object>();
		param.add(time);
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     public boolean SddeChatUser(Chat chat) throws Exception{//手动删除消息
    	 boolean flag=false;
     	String sql = "delete from tblchat where messageid = ?";
     	List<Object> param = new ArrayList<Object>();
		param.add(chat.getMessageid());
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     //所有的聊天记录
     public Chat find(Chat chat) throws Exception{
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
    	 		+ "where fromuserid = ? and touserid = ? ";
    	 List<Object> param = new ArrayList<Object>();
    	 param.add(chat.getFromuserid());
    	 param.add(chat.getTouserid());
    	 ArrayList<Chat> message=(ArrayList)conn.
					queryForArrObject(sql, param, Chat.class);
    	 return message.get(0);
     }
     
     //按天查消息记录
     public Chat findByDay(Chat chat) throws Exception{
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
    	 		+ "where fromuserid = ? and touserid = ? and sendtime = ?";
    	 List<Object> param = new ArrayList<Object>();
    	 param.add(chat.getFromuserid());
    	 param.add(chat.getTouserid());
    	 param.add(chat.getSendtime());
    	 ArrayList<Chat> message=(ArrayList)conn.
					queryForArrObject(sql, param, Chat.class);
    	 return message.get(0);
     }
     
     //按关键字查消息记录
     public Chat findByWord(Chat chat) throws Exception
     {
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
     	 		+ "where fromuserid = ? and touserid = ? and messages like '%?%'";
     	 List<Object> param = new ArrayList<Object>();
     	 param.add(chat.getFromuserid());
     	 param.add(chat.getTouserid());
     	 param.add(chat.getMessages());
     	 ArrayList<Chat> message=(ArrayList)conn.
 					queryForArrObject(sql, param, Chat.class);
     	 return message.get(0);
     }
}
