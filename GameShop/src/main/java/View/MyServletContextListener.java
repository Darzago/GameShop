package presentation.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import logic.Configuration;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Servlet implementation class HelloWorldServlet
 */

@WebListener
public class MyServletContextListener implements ServletContextListener {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletContextListener() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String jdbcURL = ctx.getInitParameter("db.url");
        String userName = ctx.getInitParameter("db.user");
        String password = ctx.getInitParameter("db.password");
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        try {
			Configuration.setConnection(DriverManager.getConnection(jdbcURL , connectionProps));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
