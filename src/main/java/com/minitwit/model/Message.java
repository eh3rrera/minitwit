package com.minitwit.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private int id;
	
	private int userId;
	
	private String username;
	
	private String text;
	
	private Date pubDate;
	
	private String pubDateStr;
	
	private String gravatar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
		if(pubDate != null) {
			pubDateStr = new SimpleDateFormat("yyyy-MM-dd @ HH:mm").format(pubDate);
		}
	}

	public String getPubDateStr() {
		return pubDateStr;
	}

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
}
