package com.minitwit.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.minitwit.dao.MessageDao;
import com.minitwit.model.Message;
import com.minitwit.model.User;
import com.minitwit.util.GravatarUtil;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private static final String GRAVATAR_DEFAULT_IMAGE_TYPE = "monsterid";
	private static final int GRAVATAR_SIZE = 48;
	private NamedParameterJdbcTemplate template;

  private RowMapper<Message> messageMapper = (rs, rowNum) -> {
    Message m = new Message();
    m.setMessageId(rs.getInt("message_id"));
    m.setUserId(rs.getInt("author_id"));
    m.setUsername(rs.getString("username"));
    m.setText(rs.getString("text"));
    m.setPubDate(rs.getTimestamp("pub_date"));
    m.setGravatar(GravatarUtil.gravatarURL(rs.getString("email"), GRAVATAR_DEFAULT_IMAGE_TYPE, GRAVATAR_SIZE));

    return m;
  };

  @Autowired
	public MessageDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<Message> getUserTimelineMessages(User user, int step, int pageNow) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", user.getUserId());
		String sql = "SELECT message.*, user.* FROM message, user WHERE user.user_id = message.author_id AND user.user_id = :id ORDER BY message.pub_date DESC limit " + (pageNow - 1) * step + ", " + step;
		List<Message> result = template.query(sql, params, messageMapper);
		
		return result;
	}

	@Override
	public List<Message> getUserFullTimelineMessages(User user, int step, int pageNow) {
		Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", user.getUserId());
		String sql = "SELECT message.*, user.* FROM message, user WHERE message.author_id = user.user_id AND (user.user_id = :id OR user.user_id IN (SELECT followee_id FROM follower WHERE follower_id = :id)) ORDER BY message.pub_date DESC limit " + (pageNow - 1) * step + ", " + step;
		List<Message> result = template.query(sql, params, messageMapper);

		return result;
	}

	@Override
	public void insertMessage(Message m) {
		Map<String, Object> params = new HashMap<String, Object>();
    params.put("userId", m.getUserId());
    params.put("text", m.getText());
    params.put("pubDate", m.getPubDate());
    String sql = "INSERT INTO message (author_id, text, pub_date) VALUES (:userId, :text, :pubDate)";
		template.update(sql, params);
	}

  @Override
  public List<Message> getPublicTimelineMessages(int step, int pageNow) {
    Map<String, Object> params = new HashMap<String, Object>();
    String sql = "SELECT message.*, user.* FROM message, user WHERE message.author_id = user.user_id ORDER BY message.pub_date DESC limit " + (pageNow - 1) * step + ", " + step;
    List<Message> result = template.query(sql, params, messageMapper);

    return result;
  }

  @Override
  public int getCount() {
    Map<String, Object> params = new HashMap<String, Object>();
    String sql = "SELECT COUNT(message.*) FROM message, user WHERE message.author_id = user.user_id";
    int result = template.queryForObject(sql, params, Integer.class);

    return result;
  }

  @Override
  public int getUserFullCount(User user) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", user.getUserId());
    String sql = "SELECT COUNT(message.*) FROM message, user WHERE message.author_id = user.user_id AND (user.user_id = :id OR user.user_id IN (SELECT followee_id FROM follower WHERE follower_id = :id))";
    int result = template.queryForObject(sql, params, Integer.class);

    return result;
  }

  @Override
  public int getUserCount(User user) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", user.getUserId());
    String sql = "SELECT COUNT(message.*) FROM message, user WHERE user.user_id = message.author_id AND user.user_id = :id";
    int result = template.queryForObject(sql, params, Integer.class);
    
    return result;
  }
}
