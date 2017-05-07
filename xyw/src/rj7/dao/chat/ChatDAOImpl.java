package rj7.dao.chat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Chat;
import rj7.util.Connect;
/**
 * 与好友聊天实现类
 * 
 * @author 娄梦慧
 * 
 */
public class ChatDAOImpl implements IChatDAO{
	Connect conn=Connect.getInstance();
	/**
	 * 与好友聊天
	 * 
	 * @author 娄梦慧
	 * @param Chat
	 * @return 与好友聊天结果（成功：true，失败:false）
	 */
	public boolean ChatUser(Chat chat) throws Exception{
        boolean flag=false;
 		String sql = "insert into tblchat (messageid,messages,sendtime,fromuserid,touserid,msgtype)"
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
		param.add(chat.getMsgtype());
 		int result = conn.update(sql, param);
 		if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
	/**
	 * 定时删除消息
	 * 
	 * @author 娄梦慧
	 * @param Chat
	 * @return 定时删除消息结果（成功：true，失败:false）
	 */
     public boolean DsdeChatUser(Chat chat){
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
     
 	/**
 	 * 手动删除消息
 	 * 
 	 * @author 娄梦慧
 	 * @param Chat
 	 * @return 手动删除消息结果（成功：true，失败:false）
 	 */
     public boolean SddeChatUser(Chat chat) {
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
     
 	/**
 	 * 所有聊天记录
 	 * 
 	 * @author 娄梦慧
 	 * @param Chat
 	 * @return 聊天记录列表
 	 */
     public ArrayList<Chat> find(Chat chat){
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
    	 		+ "where fromuserid = ? and touserid = ? ";
    	 List<Object> param = new ArrayList<Object>();
    	 param.add(chat.getFromuserid());
    	 param.add(chat.getTouserid());
    	 ArrayList<Chat> message=(ArrayList)conn.
					queryForArrObject(sql, param, Chat.class);
    	 return message;
     }
     
     /**
  	 * 按天查消息记录
  	 * 
  	 * @author 娄梦慧
  	 * @param Chat
  	 * @return 聊天记录列表
  	 */
     public ArrayList<Chat> findByDay(Chat chat) {
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
    	 		+ "where fromuserid = ? and touserid = ? and sendtime = ?";
    	 List<Object> param = new ArrayList<Object>();
    	 param.add(chat.getFromuserid());
    	 param.add(chat.getTouserid());
    	 param.add(chat.getSendtime());
    	 ArrayList<Chat> message=(ArrayList)conn.
					queryForArrObject(sql, param, Chat.class);
    	 return message;
     }
     
     /**
   	 * 按关键字查消息记录
   	 * 
   	 * @author 娄梦慧
   	 * @param Chat
   	 * @return 聊天记录列表
   	 */
     public ArrayList<Chat> findByWord(Chat chat) 
     {
    	 String sql = "select messages,sendtime,fromuserid from tblchat"
     	 		+ "where fromuserid = ? and touserid = ? and messages like '%?%'";
     	 List<Object> param = new ArrayList<Object>();
     	 param.add(chat.getFromuserid());
     	 param.add(chat.getTouserid());
     	 param.add(chat.getMessages());
     	 ArrayList<Chat> message=(ArrayList)conn.
 					queryForArrObject(sql, param, Chat.class);
     	 return message;
     }
}
