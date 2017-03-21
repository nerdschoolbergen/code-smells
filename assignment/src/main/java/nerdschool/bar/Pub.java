package nerdschool.bar;

import java.util.HashMap;
import java.util.Map;

import static nerdschool.bar.Pub.Ingredient.*;

public class Pub {

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public static final int MAX_AMOUNT_OF_COCKTAILS_IN_ONE_PURCHASE = 2;
    private final Map<String, Beverage> menu = new HashMap<>();

    enum Ingredient {
        RUM(65), GRENADINE(10), LIME_JUICE(10), GREEN_STUFF(15), TONIC_WATER(15), GIN(85);

        private int price;

        Ingredient(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public Pub() {
        menu.put(ONE_BEER, new Beverage(74));
        menu.put(ONE_CIDER, new Beverage(103));
        menu.put(A_PROPER_CIDER, new Beverage(110));
        menu.put(GT, Beverage.fromIngredients(
                new IngredientAmount(GIN, 1),
                new IngredientAmount(TONIC_WATER, 1),
                new IngredientAmount(GREEN_STUFF, 1)
        ));
        menu.put(BACARDI_SPECIAL, Beverage.fromIngredients(
                new IngredientAmount(GIN, 0.5),
                new IngredientAmount(RUM, 1),
                new IngredientAmount(GRENADINE, 1),
                new IngredientAmount(LIME_JUICE, 1)
        ));
    }

    public int computeCost(String drinkName, boolean student, int amount) {

        if (!menu.containsKey(drinkName)) {
            throw new RuntimeException("No such drink");
        }

        Beverage beverage = menu.get(drinkName);

        if (amount > MAX_AMOUNT_OF_COCKTAILS_IN_ONE_PURCHASE && beverage.isAmountLimited()) {
            throw new RuntimeException("Too many drinks, max 2.");
        }

        int price = beverage.getPrice();

        if (student && (drinkName == ONE_CIDER || drinkName == ONE_BEER || drinkName == A_PROPER_CIDER)) {
            price = price - price / 10;
        }
        return price * amount;
    }

}
