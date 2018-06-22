package logic;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
	private List<Article> articleList = new ArrayList<Article>();
	
    private double endSum;
    
    public double getEndSum() 
    {
    
    	return endSum;
    }

    public void setEndSum(double endSum) 
    {
    	this.endSum = endSum;
    }
	
	public List<Article> getArticles()
	{
		return this.articleList;
	} 

	public ShoppingCart(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	public ShoppingCart()
	{
		this.articleList = new ArrayList<Article>();
	}
	
	
}
