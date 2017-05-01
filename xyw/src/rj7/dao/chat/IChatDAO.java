package rj7.dao.chat;

import rj7.bean.Chat;

public interface IChatDAO {
	public boolean ChatUser(Chat chat) throws Exception;
	public boolean DsdeChatUser(Chat chat) throws Exception;
	public boolean SddeChatUser(Chat chat) throws Exception;
}
