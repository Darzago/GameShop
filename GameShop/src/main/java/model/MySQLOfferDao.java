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
	
	public MySQLOfferDao()
	{
		try {
			con = Configuration.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Offer> getOffersForGame(Game game) {

		//TODO Bis jetzt noch nicht ans game gebundene 
        List<Offer> tempList = new ArrayList<Offer>();
        try
        {
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM OFFERS");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
            	Offer newOffer = new Offer();
            	newOffer.setGameName(rs.getString("Name"));
            	newOffer.setEmail(rs.getString("EMAIL"));
            	newOffer.setPrice(rs.getDouble("PRICE"));
            	newOffer.setPrice(rs.getInt("AMOUNT"));
                tempList.add(newOffer);
                System.out.println("Offer added to returning offer List");
            }
            
        }
        catch(SQLException e)
        {
            //System.out.println(e.getStackTrace()+ "whas ist geschein!!!");
            System.out.println(e.getMessage()+ "whas ist geschein!!!");
        }
        
        return tempList;
	}

	@Override
	public void addOffer(Offer offer) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Offers(Name, Email, Price, Amount) VALUES(?,?,?,?)");
			pstmt.setString(1, offer.getGameName());
			pstmt.setString(2, offer.getEmail());
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
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Offers WHERE Email = ? AND Name = ?");
			pstmt.setString(1, offer.getEmail());
			pstmt.setString(2, offer.getGameName());
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
			PreparedStatement pstmt = con.prepareStatement("UPDATE Offers SET PRICE=?, AMOUNT=? WHERE Name = ? AND Email = ?");
			pstmt.setDouble(1, offer.getPrice());
			pstmt.setInt(2, offer.getAmount());
			pstmt.setString(3, offer.getGameName());
			pstmt.setString(4, offer.getEmail());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
