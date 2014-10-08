package fancyfoods.chocolate;

import fancyfoods.food.*;
import fancyfoods.offers.*;

public class RomanticChocolateOffer implements SpecialOffer {

    @Override
    public Food getOfferFood() {
        return new Chocolate();
    }

    @Override
    public String getDescription() {
        return "A wonderful surprise for someone you want to impress";
    }

}
