package logic;

import java.sql.SQLException;
import java.util.List;

import persistance.dao.ArticleDAO;
import persistance.dao.DAOFactory;

public class ShoppingCartManager {
    
    public static ArticleDAO dao = DAOFactory.getArticleDAO();
    
    public static double calculate(ShoppingCart shoppingCart) 
    {
        double totalPrice = 0;
        for(Article currentArticle : shoppingCart.getArticles())
        {
            totalPrice += currentArticle.getPrice() * currentArticle.getAmount();
        }
        shoppingCart.setEndSum(totalPrice);
        return totalPrice;
    }
    
    public static void checkout(ShoppingCart shoppingCart) throws SQLException {
        List<Article> articleList = shoppingCart.getArticles();
        Article tempNewArticle;
        
        for(Article currentArticle : articleList) {
            tempNewArticle = dao.getArticle(currentArticle.getId());
            
            //darf nicht kleiner 0 werden und muss synchronized sein
            int tempAmount = tempNewArticle.getAmount() - currentArticle.getAmount();
            if(tempAmount < 0) {
                tempAmount = tempNewArticle.getAmount();
                System.err.println("NOT IN STORAGE");
            }    
            tempNewArticle.setAmount(tempAmount);
            dao.updateArticle(tempNewArticle);
        }
        
        shoppingCart = new ShoppingCart(null);
    }
    
    public static void addArticle(ShoppingCart shoppingCart, int articleId)
    {
    	ArticleManager manager = new ArticleManager();
    	try 
    	{
    		
			Article newArticle = manager.getArticle(articleId);
			
			Article foundArticle = null;
			for(Article currentArticle : shoppingCart.getArticles())
			{
				if(currentArticle.getId() == articleId)
				{
					foundArticle = currentArticle;
				}
			}
			
			if(foundArticle != null)
			{
				foundArticle.setAmount(foundArticle.getAmount() + 1);
			}
			else if(foundArticle == null)
	        {
	            shoppingCart.getArticles().add(new Article(newArticle.getId(), newArticle.getName(), newArticle.getPrice(), 1));
	        }
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
    	
    	shoppingCart.setEndSum(ShoppingCartManager.calculate(shoppingCart));
    }

    public static void removeArticle(int id, ShoppingCart cart) throws Exception
    {
       Article foundArticle = null;
       for(Article currentArticle : cart.getArticles())
       {
           if(currentArticle.getId() == id)
           {
               foundArticle = currentArticle;
           }
       }
       
       if(foundArticle != null)
       {
          if(foundArticle.getAmount()>1)
        	  foundArticle.setAmount(foundArticle.getAmount() - 1);
          else
           cart.getArticles().remove(foundArticle);
       }
       
       cart.setEndSum(ShoppingCartManager.calculate(cart));
    }

}