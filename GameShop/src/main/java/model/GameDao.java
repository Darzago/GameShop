package model;

import java.util.List;

public interface GameDao {
	public List<Game> getAllGames();
	public void updateGame(Game game);
	public List<Game> findGamesByName(String searchString) ;
}
