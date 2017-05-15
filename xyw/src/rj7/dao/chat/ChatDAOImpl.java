package rj7.dao.chat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Chat;
import rj7.bean.Member;
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
 		String sql = "insert into tblchat (messages,sendtime,fromuserid,touserid,msgtype)"
 				+ "values (?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'),?,?,?)";
 		ArrayList param=new ArrayList();
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
     public boolean DsdeChatUser( ){
    	 boolean flag=false;
     	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=format.format(date);
     	String sql = "delete from tblchat where year(sendtime) < (year(?)-0.5)";
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
     public boolean SddeChatUser(String messageid) {
    	 boolean flag=false;
     	String sql = "delete from tblchat where messageid = ?";
     	List<Object> param = new ArrayList<Object>();
		param.add(messageid);
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
 	/**
 	 * 聊天记录
 	 * 
 	 * @author 娄梦慧
 	 * @param Chat
 	 * @return 聊天记录列表
 	 */
     public ArrayList<Chat> queryRecord(Chat chat){
		 Connect conn=Connect.getInstance();
		 String sql1 = "select messages,sendtime,fromuserid from tblchat where 1=1";
		 List<Object> param1=new ArrayList<Object>();
		 if(chat.getMessages()!=null)
		 {
			 sql1=sql1+" and messages LIKE ?";
	         param1.add("%"+chat.getMessages()+"%");
		 }
		 if(chat.getSendtime()!=null)
		 {
			 sql1=sql1+" and sendtime = ?";
			 param1.add(chat.getSendtime());
		 }
		 sql1=sql1+" and fromuserid = ?";
		 param1.add(chat.getFromuserid());
		 sql1=sql1+" and touserid = ?";
		 param1.add(chat.getTouserid());
		 ArrayList<Chat> list1=new ArrayList<Chat>();
		 list1=(ArrayList)conn.queryForArrObject(sql1, param1, Chat.class);
		 
		 String sql = "select messages,sendtime,fromuserid from tblchat where 1=1";
		 List<Object> param=new ArrayList<Object>();
		 if(chat.getMessages()!=null)
		 {
			 sql=sql+" and messages LIKE ?";
	         param.add("%"+chat.getMessages()+"%");
		 }
		 if(chat.getSendtime()!=null)
		 {
			 sql=sql+" and sendtime = ?";
			 param.add(chat.getSendtime());
		 }
		 sql=sql+" and fromuserid = ?";
		 param.add(chat.getTouserid());
		 sql=sql+" and touserid = ?";
		 param.add(chat.getFromuserid());
		 ArrayList<Chat> list2=new ArrayList<Chat>();
		 list2=(ArrayList)conn.queryForArrObject(sql, param, Chat.class);
		 
		 ArrayList<Chat> listFinal = new ArrayList<Chat>();
	        listFinal.addAll(list1);
	        listFinal.addAll(list2);
		 return listFinal;
	 }  
}
