package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.DAOFactory;
import model.Offer;

@ManagedBean (name="offerBean")
@SessionScoped
public class OfferBean {
	private Offer offer = new Offer();

	/**
	 * @return the offer
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * @param offer the offer to set
	 */
	public void setOffer(Offer offer) 
	{
		this.offer = offer;
	}
	
	public String createOffer(String email)
	{
		this.offer.setEmail(email);
		System.out.println(email+" "+this.offer.getName()+" "+this.offer.getPrice()+" "+this.offer.getAmount());
		if(this.offer.getEmail() != null && this.offer.getName() != null &&
		   this.offer.getAmount()!= 0)
		{
			DAOFactory.getOfferDao().addOffer(this.offer);
			return "Success";
		}
		return "Failed";
	}
	
}
