package presentation.servlets;
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
            
            String dropStatement = "DROP TABLE IF EXISTS ARTICLES";
			PreparedStatement dropstmt = con.prepareStatement(dropStatement);
			dropstmt.execute();
			
	        String 	createStatement	= "CREATE TABLE ARTICLES(ID INT PRIMARY KEY, NAME VARCHAR2(255), PRICE DOUBLE, AMOUNT INT)";
	        PreparedStatement createstmt = con.prepareStatement(createStatement);
	        createstmt.executeUpdate();
	        
	        
	        for(int i = 0; i<5 ; i++){
	        	String insertStatement = "INSERT INTO ARTICLES VALUES(" + i + ", 'articlename', 1.22, 2)";
	        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
	        	insertstmt.executeUpdate();
	        }
			
		
			
			
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
