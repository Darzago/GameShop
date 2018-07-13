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
	        		+ "PICTUREURL VARCHAR2(255),"
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
	        
	        
        	String insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('Monster Hunter World', 'https://s.pacn.ws/640/ul/monster-hunter-world-capture-guide-550747.2.jpg?p2kw7s', 'Tolles Spiel, much wow')";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('GertAME 2', 'www.istmirega.de', 'Geht so Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('GAtrzME 3', 'www.leckmich.de', 'Sehr tolles Spiel')";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO GAMES(NAME, PICTUREURL, DESCRIPTION) VALUES('ASDfAME 4', 'www.scheiﬂen.com', 'Meh Spiel')";
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
        	
        	insertStatement = "INSERT INTO OFFERS VALUES('GAtrzME 3', 'sehr@tolles.spiel', 45.20, 24)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES('GsadAME 1', 'sehr@tolles.spiel', 50, 4)";
        	 insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.executeUpdate();
        	insertStatement = "INSERT INTO OFFERS VALUES('ASDfAME 4', 'ein@spiel.de', 5, 1)";
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
