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
import model.User;

@ManagedBean (name="offerListBean")
@SessionScoped
public class OfferListBean 
{
	
	private List<Offer> offerlist = new ArrayList<Offer>();
	
	public List<Offer> getOffersByGame(Game queryGame)
	{
		return DAOFactory.getOfferDao().getOffersForGame(queryGame);
	}
	
	public List<Offer> getOffersByUser(User user)
	{
		return DAOFactory.getOfferDao().getOffersForUser(user);
	}
	
	public String buyGameOffer(Offer offer)
	{
		System.out.println("Amount: " + offer.getAmount());
		if(offer.getAmount() > 1)
		{
			offer.setAmount(offer.getAmount() - 1);
			DAOFactory.getOfferDao().updateOffer(offer);
			return "Success";
		}
		else
		{
			DAOFactory.getOfferDao().removeOffer(offer);
			return "Success";
		}
		
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
