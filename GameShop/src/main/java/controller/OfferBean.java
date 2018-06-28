package controller;

import javax.faces.bean.ManagedBean;

import model.Offer;

@ManagedBean
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
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	
}
