package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM GAMES");
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
            	Game newGame = new Game();
            	newGame.setName(rs.getString("NAME"));
            	//TODO
            	newGame.setImageUrl(rs.getString("PICTUREURL"));
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
	public void updateGame(Game game) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE GAMES SET NAME=?, DESCRIPTION=? WHERE Name = ?");
			
			pstmt.setString(1, game.getName());
			pstmt.setString(2, game.getDescription());
			pstmt.setString(3, game.getName());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Override
	public List<Game> findGamesByName(String searchString) 
	{
        List<Game> tempList = new ArrayList<Game>();
        
        try
        {
        	PreparedStatement pstmt = con.prepareStatement("select * from Games WHERE UPPER(NAME) LIKE UPPER('%"+searchString+"%')");
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
            	Game newGame = new Game();
            	newGame.setName(rs.getString("NAME"));
            	//TODO
            	newGame.setImageUrl(rs.getString("PICTUREURL"));
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

}
