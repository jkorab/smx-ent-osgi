package fancyfoods.offers.impl;

import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfferAggregator implements CurrentOffers {

    private static final int MAX_OFFERS = 4;
    private List<SpecialOffer> offers;

    public void setOffers(List<SpecialOffer> offers) {
        this.offers = offers;
    }

    @Override
    public List<SpecialOffer> getCurrentOffers() {
        List<SpecialOffer> sortedOffers = new ArrayList<>(offers);
        Collections.sort(sortedOffers, new OfferComparator());
        int offerCount = Math.min(MAX_OFFERS, sortedOffers.size());
        return sortedOffers.subList(0, offerCount);
    }

    private class OfferComparator implements java.util.Comparator<SpecialOffer> {
        @Override
        public int compare(SpecialOffer o1, SpecialOffer o2) {
            return ((Double) o2.getOfferFood().getPrice()).compareTo(o1.getOfferFood().getPrice());
        }
    }
}
