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
	public boolean DsdeChatUser(Chat chat) ; //定时删除消息
	public boolean SddeChatUser(Chat chat) ;// 删除特定的消息
	public ArrayList<Chat> find(Chat chat) ;//所有的聊天记录
	public ArrayList<Chat> findByDay(Chat chat) ;//按天查询聊天记录
	public ArrayList<Chat> findByWord(Chat chat) ;//按关键字查询聊天记录
}
