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
        Beverage gt = Beverage.fromIngredients(
                new IngredientAmount(Ingredient.GIN, 1),
                new IngredientAmount(Ingredient.TONICWATER, 1),
                new IngredientAmount(Ingredient.GREENSTUFF, 1)
        );
        Beverage bacardiSpecial = Beverage.fromIngredients(
                new IngredientAmount(Ingredient.GIN, 0.5),
                new IngredientAmount(Ingredient.RUM, 1),
                new IngredientAmount(Ingredient.GRENADINE, 1),
                new IngredientAmount(Ingredient.LIMEJUICE, 1)
        );

        beverages.put(oneBeer.getName(), oneBeer);
        beverages.put(oneCider.getName(), oneCider);
        beverages.put(oneProperCider.getName(), oneProperCider);
        beverages.put(GT, gt);
        beverages.put(BACARDI_SPECIAL, bacardiSpecial);
    }

    public int computeCost(String drink, boolean student, int amount) {

        if (amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;

        try {
            Beverage beverage = beverages.get(drink);
            price = beverage.getPrice();
            if (student && (drink.equals(ONE_BEER) || drink.equals(ONE_CIDER) || drink.equals(A_PROPER_CIDER))) {
                price = price - price / 10;
            }
        } catch (Exception e) {

            throw new RuntimeException("No such drink exists");
        }
        return price * amount;
    }
}