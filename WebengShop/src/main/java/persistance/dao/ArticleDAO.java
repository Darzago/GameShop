package persistance.dao;

import java.sql.SQLException;
import java.util.List;

import logic.Article;

public interface ArticleDAO 
{
		public void addArticle(Article newArticle);
		public void deleteArticle(Article oldArticle);
		public Article getArticle(int id);
		public int getMaxId();
		public void updateArticle(Article newArticle);
		public List<Article> getAllArticles();
}
