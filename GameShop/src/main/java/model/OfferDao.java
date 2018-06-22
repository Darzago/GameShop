package model;

import java.util.List;

public interface OfferDao {
	public List<Offer> getOffersForGame(Game game);
	public void addOffer(Offer offer);
	public void removeOffer(Offer offer);
	public void updateOffer(Offer offer);
}
