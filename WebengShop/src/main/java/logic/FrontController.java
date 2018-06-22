package logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistance.dao.ArticleDAO;
import persistance.dao.DAOFactory;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns ={ "/FrontController" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		if (action==null) action="login";
		
		String viewName = "";
		
		if (action.equalsIgnoreCase("login")) 
		{
			//Neue cart erstellen weiterleitung zur article list (mit leerem warenkorb)
			ShoppingCart newCart = new ShoppingCart();
			session.setAttribute("shoppingCart", newCart);
			
			ArticleManager manager = new ArticleManager();
		    List<Article> list = manager.getAllArticles();
		    
		    session.setAttribute("articleList", list);
		    
		    viewName = "ArticleList.jsp";
		}
		
		if (action.equalsIgnoreCase("checkToken")) 
        {
			String token = "ichBins";
			if(token.equals(request.getParameter("token")))
			{
				viewName = "AddArticle.jsp";
			}
			else
			{
				response.sendError(403);
			}
        }
	
		if (action.equalsIgnoreCase("addArticle")) 
        {
			
			ArticleManager manager = new ArticleManager();
			
            int nextId = manager.getMaxId()+1;
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            Article newArticle = new Article(nextId, name, price, amount);
            
            newArticle.validate();
            if(newArticle.isValid())
            {
	            try {
					manager.addArticle(newArticle);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
            }
            else
            {
            	response.sendError(418, "Article invalid");
            }
            
		    List<Article> list = manager.getAllArticles();
		    
		    session.setAttribute("articleList", list);
            
            viewName= "ArticleList.jsp";
        } 
		
		if (action.equalsIgnoreCase("buyArticle")) 
		{
			//ShoppingCarsten
			ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
			ShoppingCartManager.addArticle(shoppingCart, Integer.parseInt(request.getParameter("articleId")));

			
			session.setAttribute("shoppingCart", shoppingCart);
			
			viewName = "ArticleList.jsp";
			
		}
		
		if (action.equalsIgnoreCase("articleDetails")) 
		{
			//Je nach id die entsprechende seite mit der entsprechenden article bean aufrufen
			try {
				int _id = Integer.parseInt(request.getParameter("articleId"));
				Article article = new ArticleManager().getArticle(_id);
				request.setAttribute("article", article);
				
				viewName = "ArticleDetails.jsp";
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(action.equalsIgnoreCase("removeArticle"))
        {
            ShoppingCart cart =(ShoppingCart) session.getAttribute("shoppingCart");
            try {
                ShoppingCartManager.removeArticle(Integer.parseInt(request.getParameter("removeID")), cart);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            session.setAttribute("shoppingCart", cart);
            viewName="ArticleList.jsp";
        }
		
		if (action.equalsIgnoreCase("checkout")) 
		{
			ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
			
			try {
				ShoppingCartManager.checkout(shoppingCart);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			session.setAttribute("shoppingCart", new ShoppingCart());
			
			viewName = "Bye.jps";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
