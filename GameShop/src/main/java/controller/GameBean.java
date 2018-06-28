package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		gamelist = new DAOFactory().getGameDao().getAllGames();
		System.out.println(gamelist.toString()+"die Liste");
		return gamelist;
	}

	/**
	 * @param gameList the gameList to set
	 */
	public void setGamelist(List<Game> gameList) {
		this.gamelist = gameList;
	}


}
