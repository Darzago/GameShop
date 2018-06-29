package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLOfferDao implements OfferDao{
	
	Connection con;
	
	//TODO Get offers by User
	
	@Override
	public List<Offer> getOffersForGame(Game game) {

		//TODO Bis jetzt noch nicht ans game gebundene 
        List<Offer> tempList = new ArrayList<Offer>();
        
        try
        {
        	PreparedStatement pstmt = con.prepareStatement("select * from Offers");
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
            	Offer newOffer = new Offer();
            	newOffer.setGameId(rs.getInt("GAME_ID"));
            	newOffer.setUserId(rs.getInt("USER_ID"));
            	newOffer.setPrice(rs.getDouble("PRICE"));
            	newOffer.setPrice(rs.getInt("AMOUNT"));
                tempList.add(newOffer);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return tempList;
	}

	@Override
	public void addOffer(Offer offer) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Offers(GAME_ID, USER_ID, Price, Amount) VALUES(?,?,?,?)");
			pstmt.setInt(1, offer.getGameId());
			pstmt.setInt(2, offer.getUserId());
			pstmt.setDouble(3, offer.getPrice());
			pstmt.setInt(4, offer.getAmount());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void removeOffer(Offer offer) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Offers WHERE USER_ID = ? AND GAME_ID = ?");
			pstmt.setInt(2, offer.getGameId());
			pstmt.setInt(1, offer.getUserId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOffer(Offer offer) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE Offers SET PRICE=?, AMOUNT=? WHERE GAME_ID = ? AND USER_ID = ?");
			pstmt.setDouble(1, offer.getPrice());
			pstmt.setInt(2, offer.getAmount());
			pstmt.setInt(3, offer.getGameId());
			pstmt.setInt(4, offer.getUserId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
