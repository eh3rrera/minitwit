package com.minitwit.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

  private int messageid;
	private int userid;
	private String username;
	private String text;
	private Date pubDate;
	private String pubDateStr;
	private String gravatar;

	public int getMessageId() {
		return messageid;
	}

	public void setMessageId(int messageid) {
		this.messageid = messageid;
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
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
