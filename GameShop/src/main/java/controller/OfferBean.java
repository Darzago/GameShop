package controller;


import java.util.List;
import javax.faces.bean.ManagedBean;

import model.Offer;

@ManagedBean
public class OfferBean {
	private Offer offer;

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
