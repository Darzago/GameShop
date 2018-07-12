package controller;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.DAOFactory;
import model.User;
import model.UserDao;

@ManagedBean (name="userBean")
@SessionScoped
public class UserBean {
	
	private User user = new User();
	
	private boolean loggedIn = false;

	
	public void logOut()
	{
		this.loggedIn = false;
	}
	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	public String registerUser() throws SQLException
	{
		if(DAOFactory.getUserDao().registerUser(user))
			return "Success";
		else
			return "Failed";
	}
	
	public String loginUser()  throws SQLException
	{
		if(DAOFactory.getUserDao().checkUserPw(user))
		{
			this.loggedIn = true;
			return "Success";
		}
		else
		{
			this.loggedIn = false;
			return "Failed";
		}
	}
	
	
}
