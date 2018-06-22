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
			
	        String 	createStatement	= "CREATE TABLE GAMES(GAME_ID INT PRIMARY KEY AUTO_INCREMENT,"
	        		+ "NAME VARCHAR2(255),"
	        		+ "PICTURE BLOB,"
	        		+ "DESCRIPTION TEXT)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        		createStatement	= "CREATE TABLE USERS(USER_ID INT PRIMARY KEY AUTO_INCREMENT,"
	        		+ "NAME VARCHAR2(255),"
	        		+ "PASSWORD VARCHAR2(255),"
	        		+ "EMAIL VARCHAR2(255))";
	        createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        createStatement	= "CREATE TABLE OFFERS("
	        		+ "GAME_ID INT REFERENCES GAMES(GAME_ID),"
	        		+ "USER_ID INT REFERENCES USERS(USER_ID),"
	        		+ "PRICE DOUBLE,"
	        		+ "AMOUNT INT,"
	        		+ "PRIMARY KEY(GAME_ID,USER_ID))";
	        createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        
        	String insertStatement = "INSERT INTO GAMES(NAME, PICTURE, DESCRIPTION) VALUES('GAME 1', NULL, 'Tolles Spiel')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTURE, DESCRIPTION) VALUES('GAME 2', NULL, 'Geht so Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTURE, DESCRIPTION) VALUES('GAME 3', NULL, 'Sehr tolles Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTURE, DESCRIPTION) VALUES('GAME 4', NULL, 'Meh Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 1', '1234', 'Tolles@Spiel.de')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 2', 'abcd', 'Geht@so.Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 3', '4567', 'Sehr@tolles.Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES('USER 4', 'efgh', 'ein@Spiel.de')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	
        	insertStatement = "INSERT INTO OFFERS VALUES(2, 2, 45.20, 24)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES(2, 1, 50, 4)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES(1, 3, 5, 1)";
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
            	response.getWriter().append(rs.getInt("Game_ID") + "\t" + rs.getString("NAME") + "\n");
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