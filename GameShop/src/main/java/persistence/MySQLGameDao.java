package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



public class MySQLGameDao implements GameDao{

	Connection con;
	
	public MySQLGameDao() {
		/*try {
			//TODO
			//con = Configuration.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	@Override
	public List<Game> getAllGames() {
		
		
		
		return null;
	}

	@Override
	public void addGame(Game game) {
		
	}

	@Override
	public void removeGame(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(Game game) {
		// TODO Auto-generated method stub
		
	}

}
