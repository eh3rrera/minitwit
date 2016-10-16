package com.minitwit.dao;

import java.util.List;

import com.minitwit.model.Message;
import com.minitwit.model.User;

public interface MessageDao {
	List<Message> getUserTimelineMessages(User user, int step, int pageNow);
	
	List<Message> getUserFullTimelineMessages(User user, int step, int pageNow);
	
	List<Message> getPublicTimelineMessages(int step, int pageNow);
	
	void insertMessage(Message m);

  int getCount();

  int getUserFullCount(User user);

  int getUserCount(User user);
}
