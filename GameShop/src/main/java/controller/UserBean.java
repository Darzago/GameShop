package controller;

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
	
	public void registerUser()
	{
		System.out.println(user.getName() + user.getEmail() + user.getPassword());
		
		
	}
	
	
}
