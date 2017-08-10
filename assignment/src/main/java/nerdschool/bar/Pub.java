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
    final int MAX_AMOUNT_OF_COCKTAILS_PER_ORDER = 2;
    final int STUDENT_DISCOUNT = 10;


    public Pub() {
        beverages.put(ONE_BEER, new Beverage(74, false));
        beverages.put(ONE_CIDER, new Beverage(103, false));
        beverages.put(A_PROPER_CIDER, new Beverage(110, false));
        beverages.put(GT, Beverage.fromIngredients(
                new IngredientAmount(Ingredient.GIN, 1),
                new IngredientAmount(Ingredient.TONICWATER, 1),
                new IngredientAmount(Ingredient.GREENSTUFF, 1)
        ));
        beverages.put(BACARDI_SPECIAL, Beverage.fromIngredients(
                new IngredientAmount(Ingredient.GIN, 0.5),
                new IngredientAmount(Ingredient.RUM, 1),
                new IngredientAmount(Ingredient.GRENADINE, 1),
                new IngredientAmount(Ingredient.LIMEJUICE, 1)
        ));
    }

    public int computeCost(String drink, boolean student, int amount) {

        if (!beverages.containsKey(drink)) {
            throw new RuntimeException("No such drink exists");
        }

        Beverage beverage = beverages.get(drink);

        if (amount > MAX_AMOUNT_OF_COCKTAILS_PER_ORDER && beverage.isAmountLimited()) {
            throw new RuntimeException(String.format("Too many cocktails, max %d per order.", MAX_AMOUNT_OF_COCKTAILS_PER_ORDER));
        }

        int price = beverage.getPrice();

        if (student && !beverage.isAmountLimited()) {
            price = price - price / STUDENT_DISCOUNT;
        }
        return price * amount;
    }
}
