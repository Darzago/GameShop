import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/Navigation" })
public class Navigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Navigation() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Navi</h1>");
		response.getWriter().append("<ul>");
		response.getWriter().append("<a href=\"../webeng02/MyServlet?action=home\"><li>Home</li></a>");
		response.getWriter().append("<a href=\"../webeng02/MyServlet?action=header\"><li>Header</li></a>");
		response.getWriter().append("<a href=\"../webeng02/MyServlet?action=cookies\"><li>Cookies</li></a>");
		response.getWriter().append("<a href=\"../webeng02/MyServlet?action=search\"><li>Search</li></a>");
		response.getWriter().append("</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
