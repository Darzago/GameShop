package persistance.dao;

public class DAOFactory
{
	public static ArticleDAO getArticleDAO() 
	{
		return new MySQLArticleDAO();
	}
}
