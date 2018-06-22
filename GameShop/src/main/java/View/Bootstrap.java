package view;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Configuration;

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
			PreparedStatement dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			dropStatement = "DROP TABLE IF EXISTS Games";
			PreparedStatement dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			
	        String 	createStatement	= "CREATE TABLE GAMES(GAME_ID INT PRIMARY KEY AUTOINCREMENT,"
	        		+ "NAME VARCHAR2(255),"
	        		+ "PICTURE ORDSYS.ORDIMGF,"
	        		+ "DESCRIPTION TEXT)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        		createStatement	= "CREATE TABLE USERS(USER_ID INT PRIMARY KEY AUTOINCREMENT,"
	        		+ "NAME VARCHAR2(255),"
	        		+ "PASSWORD VARCHAR2,"
	        		+ "EMAIL VARCHAR2)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        createStatement	= "CREATE TABLE OFFERS("
	        		+ "GAME_ID INT FOREIGN KEY GAMES(GAME_ID),"
	        		+ "USER_ID INT FOREIGN KEY USERS(USER_ID),"
	        		+ "PRICE DOUBLE,"
	        		+ "AMOUNT INT)"
	        		+ "PRIMARY KEY(GAME_ID,USER_ID)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        
        	String insertStatement = "INSERT INTO GAMES VALUES('GAME 1', NULL, Tolles Spiel)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES VALUES('GAME 2', NULL, Geht so Spiel)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES VALUES('GAME 3', NULL, Sehr tolles Spiel)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES VALUES('GAME 4', NULL, Spiel)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	
        	insertStatement = "INSERT INTO USERS VALUES('USER 1', '1234', 'Tolles@Spiel.de')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS VALUES('USER 2', 'abcd', 'Geht@so.Spiel')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS VALUES('USER 3', '4567', 'Sehr@tolles.Spiel')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO USERS VALUES('USER 4', 'efgh', 'ein@Spiel.de')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	
        	insertStatement = "INSERT INTO OFFERS VALUES(0, 2, 45.20, 24)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES(0, 1, 50, 4)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES(1, 3, 5, 1)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
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
		response.getWriter().append("Values from table 'Articles':\n");
		
		String query = "select ID,NAME"
        		+ " from ARTICLES";

        try
        {
        	// get connection dbstarter-contextListener (settings in web.xml)
        	Connection con = Configuration.getConnection();
        	       	
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while (rs.next()) {
            	response.getWriter().append(rs.getString("ID") + "\t" + rs.getString("NAME") + "\n");
            	//System.out.println(rs.getString("NAME"));
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
