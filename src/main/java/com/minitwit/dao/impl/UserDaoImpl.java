package com.minitwit.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.minitwit.dao.UserDao;
import com.minitwit.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private NamedParameterJdbcTemplate template;

	@Autowired
	public UserDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public User getUserbyUsername(String username) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", username);
        
		String sql = "SELECT * FROM user WHERE username=:name";
		
        List<User> list = template.query(
                    sql,
                    params,
                    userMapper);
        
        User result = null;
        if(list != null && !list.isEmpty()) {
        	result = list.get(0);
        }
        
		return result;
	}

	@Override
	public void insertFollower(User follower, User followee) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("follower", follower.getId());
        params.put("followee", followee.getId());
        
		String sql = "insert into follower (follower_id, followee_id) values (:follower, :followee)";
		
        template.update(sql,  params);
	}

	@Override
	public void deleteFollower(User follower, User followee) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("follower", follower.getId());
        params.put("followee", followee.getId());
        
		String sql = "delete from follower where follower_id = :follower and followee_id = :followee";
		
        template.update(sql,  params);
	}
	
	@Override
	public boolean isUserFollower(User follower, User followee) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("follower", follower.getId());
        params.put("followee", followee.getId());
        
		String sql = "select count(1) from follower where " +
            "follower.follower_id = :follower and follower.followee_id = :followee";
		
		Long l = template.queryForObject(sql, params, Long.class);
		
		return l > 0;
	}

	@Override
	public void registerUser(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", user.getUsername());
        params.put("email", user.getEmail());
        params.put("pw", user.getPassword());
        
		String sql = "insert into user (username, email, pw) values (:username, :email, :pw)";
		
        template.update(sql,  params);
	}

	private RowMapper<User> userMapper = (rs, rowNum) -> {
		User u = new User();
		
		u.setId(rs.getInt("user_id"));
		u.setEmail(rs.getString("email"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("pw"));
		
		return u;
	};
}
