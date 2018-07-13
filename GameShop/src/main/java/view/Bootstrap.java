package view;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/Bootstrap" })
public class Bootstrap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bootstrap() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        super.init();
        

        
        try {
            Connection con = Configuration.getConnection();
            
            String dropStatement = "DROP TABLE IF EXISTS Offers";
			PreparedStatement dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			dropStatement = "DROP TABLE IF EXISTS Users";
			dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			dropStatement = "DROP TABLE IF EXISTS Games";
			dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			
	        String 	createStatement	= "CREATE TABLE GAMES(NAME VARCHAR2(255) PRIMARY KEY,"
	        		+ "PICTUREURL TEXT,"
	        		+ "DESCRIPTION TEXT)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        		createStatement	= "CREATE TABLE USERS(NAME VARCHAR2(255),"
	        		+ "PASSWORD VARCHAR2(255),"
	        		+ "EMAIL VARCHAR2(255) PRIMARY KEY)";
	        createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        createStatement	= "CREATE TABLE OFFERS("
	        		+ "Name VARCHAR(255) REFERENCES GAMES(Name),"
	        		+ "EMAIL VARCHAR2(255) REFERENCES USERS(EMAIL),"
	        		+ "PRICE DOUBLE,"
	        		+ "AMOUNT INT,"
	        		+ "PRIMARY KEY(Name,EMAIL))";
	        createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        
        	String insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Monster Hunter World', 'http://www.buffed.de/screenshots/original/2018/01/Monster-Hunter-World-Artwork-pc-games_b2article_artwork.jpg', 'Tolles Spiel, much wow')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Rocket League', 'http://www.pcgameshardware.de/screenshots/original/2015/07/Rocket_League_Autofussball_kann_die_Massen_noch_begeistern__6_-pcgh_b2article_artwork.jpg', 'Lustiges Spiel, ganz viele Autos')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Assasins Creed: Origins', 'http://static.4players.de/premium/Spiele/97/00/38394-teaser1.jpg', 'Sehr tolles Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Dark Souls 3', 'https://cdn.gamerant.com/wp-content/uploads/dark-souls-3-cover.jpg.optimal.jpg', 'Meh Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Oxenfree', 'https://images-eds-ssl.xboxlive.com/image?url=8Oaj9Ryq1G1_p3lLnXlsaZgGzAie6Mnu24_PawYuDYIoH77pJ.X5Z.MqQPibUVTcYPwI5m0CIBk0DdeMRHf40OKpHuamQrbOgUsgBiCFKkJD3KVnibaCkCioZWF3RqEAdthJpWskfwyf6PQadF8UptX5UsbEmT32_u5n6TIbVB9JkKtcFD3CRtsTMO_LLRinpnaGNLtRO_nf3i5ecoRmOVxbJblSeqt.SBG9Ib1nKfc-&h=1080&w=1920&format=jpg', 'Story Game')";
       	 	insertstmt = con.prepareStatement(insertStatement);
       	 	insertstmt.executeUpdate();
       	
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 1', '1234', 'tolles@spiel.de')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 2', 'abcd', 'geht@so.spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 3', '4567', 'sehr@tolles.spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 4', 'efgh', 'ein@spiel.de')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	
        	insertStatement = "INSERT INTO OFFERS VALUES('Assasins Creed: Origins', 'sehr@tolles.spiel', 45.20, 24)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES('Monster Hunter World', 'sehr@tolles.spiel', 50, 4)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES('Dark Souls 3', 'ein@spiel.de', 5, 1)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Hello HelloDataSource\n"); 
		response.getWriter().append("Values from table 'Games':\n");
		
		String query = "select *"
        		+ " from Games";

        try
        {
        	// get connection dbstarter-contextListener (settings in web.xml)
        	Connection con = Configuration.getConnection();
        	       	
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while (rs.next()) {
            	response.getWriter().append(rs.getString("NAME") + "\n");
            }
            
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
