package com.minitwit.dao;

import java.util.List;

import com.minitwit.model.Message;
import com.minitwit.model.User;

public interface MessageDao {
	List<Message> getUserTimelineMessages(User user);
	
	List<Message> getUserFullTimelineMessages(User user);
	
	List<Message> getPublicTimelineMessages();
	
	void insertMessage(Message m);
}
