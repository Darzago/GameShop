package model;

public interface UserDao {
	public boolean registerUser(User user);
	public boolean checkUserPw(User user);
}