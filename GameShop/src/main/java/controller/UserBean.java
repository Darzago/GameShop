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
			return "Success";
		else 
			return "Failed";
	}
	
	
}
