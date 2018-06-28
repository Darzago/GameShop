package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;

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
	
	
	public void registerUser()
	{
		System.out.println(user.getName());
		
	}
	
	
}
