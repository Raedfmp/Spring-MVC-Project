package de.fmp.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper  implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUser_id(rs.getInt(1));
		user.setUser_name(rs.getString(2));
		user.setUser_role(rs.getString(3));
		return user;
	}

}
