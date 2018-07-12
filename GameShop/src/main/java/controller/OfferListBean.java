package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAOFactory;
import model.Game;
import model.Offer;

@ManagedBean (name="offerListBean")
@SessionScoped
public class OfferListBean 
{
	
	private List<Offer> offerlist = new ArrayList<Offer>();
	
	public List<Offer> getOffersByQuery()
	{
		Game queryGame = new Game();
		String gameId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("gameId");
		List<Game> tempList = DAOFactory.getGameDao().findGamesByName(gameId);
		for(Game tempGame : tempList)
		{
			queryGame = tempGame;
			break;
		}
		
		return DAOFactory.getOfferDao().getOffersForGame(queryGame);
	}
	
	/**
	 * @return the offerlist
	 */
	public List<Offer> getOfferlist() 
	{
		this.offerlist = DAOFactory.getOfferDao().getOffersForGame(new Game());
		
		return offerlist;
	}

	/**
	 * @param offerlist the offerlist to set
	 */
	public void setOfferlist(List<Offer> offerlist) {
		this.offerlist = offerlist;
	}
	
}
