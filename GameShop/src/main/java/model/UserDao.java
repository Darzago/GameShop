package model;

import java.sql.SQLException;

public interface UserDao {
	public boolean registerUser(User user) throws SQLException;
	public boolean checkUserPw(User user) throws SQLException;
}
