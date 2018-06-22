package controller;

import javax.faces.bean.ManagedBean;

import persistence.Game;

@ManagedBean
public class GameBean {
	private Game game;

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
	
	
}
