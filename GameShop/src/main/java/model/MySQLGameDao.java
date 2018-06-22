package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.cglib.core.GeneratorStrategy;



public class MySQLGameDao implements GameDao{

	Connection con;
	
	public MySQLGameDao() {
		try {
			con = Configuration.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Game> getAllGames() {
        List<Game> tempList = new ArrayList<Game>();
        
        try
        {
        	PreparedStatement pstmt = con.prepareStatement("select * from Games");
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
            	Game newGame = new Game();
            	newGame.setGameId(rs.getInt("GAME_ID"));
            	newGame.setName(rs.getString("NAME"));
            	//TODO
            	newGame.setImage(null);
            	newGame.setDescription(rs.getString("DESCRIPTION"));
                tempList.add(newGame);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return tempList;
	}

	@Override
	public void addGame(Game game) {
		try 
		{
			//TODO Pictures
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO GAMES(GAME_ID, NAME, DESCRIPTION) VALUES(?,?,?)");
			pstmt.setInt(1, game.getGameId());
			pstmt.setString(2, game.getName());
			pstmt.setString(3, game.getDescription());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeGame(Game game) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Games GAME_ID = ?");
			pstmt.setInt(1, game.getGameId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateGame(Game game) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE GAMES SET NAME=?, DESCRIPTION=? WHERE GAME_ID = ?");
			
			pstmt.setString(1, game.getName());
			pstmt.setString(2, game.getDescription());
			pstmt.setInt(3, game.getGameId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
