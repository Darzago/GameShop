package model;

public class DAOFactory {
	public GameDao getGameDao()
	{
		return new MySQLGameDao();
	}
	
	public OfferDao getOfferDao()
	{
		return new MySQLOfferDao();
	}
	
	public UserDao getUserDao()
	{
		return new MySQLUserDao();
	}
}
