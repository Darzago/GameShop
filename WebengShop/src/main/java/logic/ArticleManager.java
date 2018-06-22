package logic;

import java.sql.SQLException;
import java.util.List;

import persistance.dao.ArticleDAO;
import persistance.dao.DAOFactory;

public class ArticleManager {

    public ArticleDAO dao = DAOFactory.getArticleDAO();
    
    public void addArticle(Article newArticle) throws SQLException {
        dao.addArticle(newArticle);
    }
    
    public void deleteArticle(Article oldArticle) throws SQLException {
        dao.deleteArticle(oldArticle);
    }
    
    public Article getArticle(int id) throws SQLException {
        return dao.getArticle(id);
    }
    
    public void updateArticle(Article newArticle) throws SQLException {
        dao.updateArticle(newArticle);
    }
    public List<Article> getAllArticles()
    {
    	return dao.getAllArticles();
    }
    
    public int getMaxId()
    {
    	return dao.getMaxId();
    }
}