package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.DAOFactory;
import model.Game;

@ManagedBean
public class GameBean {
	
	private List<Game> gameList = new DAOFactory().getGameDao().getAllGames();

	/**
	 * @return the gameList
	 */
	public List<Game> getGameList() {
		return gameList;
	}

	/**
	 * @param gameList the gameList to set
	 */
	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}

}
