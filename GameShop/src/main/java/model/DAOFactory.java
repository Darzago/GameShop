package model;

public class DAOFactory {
	public static GameDao getGameDao()
	{
		return new MySQLGameDao();
	}
	
	public  static OfferDao getOfferDao()
	{
		return new MySQLOfferDao();
	}
	
	public static UserDao getUserDao()
	{
		return new MySQLUserDao();
	}
}
