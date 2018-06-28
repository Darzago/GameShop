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
	private User user;

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
	
	@PostConstruct
	public void init() {
	    user = new User();
	}
	
	
	public String registerUser() throws SQLException
	{
		UserDao userdao = DAOFactory.getUserDao();
		if(userdao.registerUser(user))
			return "Success";
		else
			return "Failed";
	}
	
	
}
