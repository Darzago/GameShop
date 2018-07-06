package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;

import model.DAOFactory;
import model.Game;
import model.User;

@ManagedBean (name="gameBean")
@SessionScoped
public class GameBean {
	
	private List<Game> gamelist = new ArrayList<Game>();

	/**
	 * @return the gameList
	 */
	public List<Game> getGamelist() {
		gamelist = DAOFactory.getGameDao().getAllGames();
		System.out.println(gamelist.toString()+"die Liste");
		return gamelist;
	}

	/**
	 * @param gameList the gameList to set
	 */
	public void setGamelist(List<Game> gameList) 
	{
		this.gamelist = gameList;
	}
	
	/**
	 * live Suche
	 * @param event
	 */
	public void doSomething(AjaxBehaviorEvent event)
	{
		String searchInput = (String)(((UIOutput) event.getSource()).getValue());
		setGamelist(DAOFactory.getGameDao().findGamesByName(searchInput));
	}



}
