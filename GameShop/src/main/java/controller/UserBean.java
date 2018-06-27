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
	
	public String registerUser()
	{
		//Insert dao shit
		if(user ==  null)
		{
			return "cancel";
		}
		
		return "ok";
	}
	
	
}
