package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.DAOFactory;
import model.Game;

@ManagedBean (name="gameDetailsBean")
@RequestScoped
public class GameDetailsBean {
	
	private Game game = new Game();
	
	public void getGameByQueryString()
	{
		String gameId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("gameId");
		List<Game> tempList = DAOFactory.getGameDao().findGamesByName(gameId);
		for(Game tempGame : tempList)
		{
			game = tempGame;
			break;
		}
		
	}
	
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	public GameDetailsBean() 
	{
		getGameByQueryString();
	}
}
