package nerdschool.bar;

import java.util.HashMap;
import java.util.Map;

public class Pub {

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    Map<String, Beverage> beverages = new HashMap<>();

    public Pub() {
        initialiseBeverages();
    }

    private void initialiseBeverages() {
        Beverage oneBeer = new Beverage(ONE_BEER, 74);
        Beverage oneCider = new Beverage(ONE_CIDER, 103);
        Beverage oneProperCider = new Beverage(A_PROPER_CIDER, 110);

        beverages.put(oneBeer.getName(), oneBeer);
        beverages.put(oneCider.getName(), oneCider);
        beverages.put(oneProperCider.getName(), oneProperCider);
    }

    public int computeCost(String drink, boolean student, int amount) {

        if (amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;

        try {
            Beverage beverage = beverages.get(drink);
            price = beverage.getPrice();
            if (student) {
                price = price - price / 10;
            }
        } catch (Exception e) {
         if (drink.equals(GT)) {
                price = Ingredient.GIN.getPrice() + Ingredient.TONICWATER.getPrice() + Ingredient.GREENSTUFF.getPrice();
            } else if (drink.equals(BACARDI_SPECIAL)) {
                price = Ingredient.GIN.getPrice() / 2 + Ingredient.RUM.getPrice() + Ingredient.GRENADINE.getPrice() + Ingredient.LIMEJUICE.getPrice();
            } else {
                throw new RuntimeException("No such drink exists");
            }
        }
        return price * amount;
    }
}