package persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Article;
import logic.Configuration;

public class MySQLArticleDAO implements ArticleDAO
{
	Connection con;

	public MySQLArticleDAO() {
		try {
			con = Configuration.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addArticle(Article newArticle)
	{
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Articles(ID, Name, Price, Amount) VALUES(?,?,?,?)");
			pstmt.setInt(1, newArticle.getId());
			pstmt.setString(2, newArticle.getName());
			pstmt.setDouble(3, newArticle.getPrice());
			pstmt.setInt(4, newArticle.getAmount());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticle(Article oldArticle) 
	{
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Articles WHERE ID = ?");
			pstmt.setInt(1, oldArticle.getId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Article getArticle(int id) 
	{
		Article article = null;
        PreparedStatement pstmt;
		try
		{
			pstmt = con.prepareStatement("SELECT ID, Name, Price, Amount FROM Articles WHERE ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(); 
			if (rs.next())
                article = new Article(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"), rs.getInt("AMOUNT"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public void updateArticle(Article newArticle) {
		try 
		{
			PreparedStatement pstmt = con.prepareStatement("UPDATE Articles SET ID=?, Name=?, Price=?, Amount=? WHERE ID = ?");
			pstmt.setInt(1, newArticle.getId());
			pstmt.setString(2, newArticle.getName());
			pstmt.setDouble(3, newArticle.getPrice());
			pstmt.setInt(4, newArticle.getAmount());
			pstmt.setInt(5, newArticle.getId());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    public List<Article> getAllArticles() {

        List<Article> tempList = new ArrayList<Article>();
        
        try
        {
            // get connection dbstarter-contextListener (settings in web.xml)
                       
        	PreparedStatement pstmt = con.prepareStatement("select * from ARTICLES");
            ResultSet rs = pstmt.executeQuery();
            
            
            while (rs.next()) 
            {
                tempList.add(new Article(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"), rs.getInt("AMOUNT")));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return tempList;
    }
	
    public int getMaxId()
    {
        PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select max(ID) from ARTICLES ");
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next())
	            return rs.getInt("max(ID)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return 0;
    }

}
