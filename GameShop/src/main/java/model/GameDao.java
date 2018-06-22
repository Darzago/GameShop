package model;

import java.util.List;

public interface GameDao {
	public List<Game> getAllGames();
	public void addGame(Game game);
	public void removeGame(Game game);
	public void updateGame(Game game);
}
