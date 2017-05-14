package rj7.dao.chat;

import java.util.ArrayList;

import rj7.bean.Chat;
/**
 * 在线聊天接口
 * 
 * @author 娄梦慧
 * 
 */
public interface IChatDAO {
	public boolean ChatUser(Chat chat) throws Exception;// 与好友聊天
	public boolean DsdeChatUser( ) ; //定时删除消息
	public boolean SddeChatUser(String messageid) ;// 删除特定的消息
	public ArrayList<Chat> queryRecord(Chat chat);//查询聊天记录
}
