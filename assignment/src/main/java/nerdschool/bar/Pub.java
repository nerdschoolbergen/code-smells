package nerdschool.bar;

import java.util.HashMap;
import java.util.Map;

public class Pub {


    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";
    public static final int STUDENT_DISCOUNT = 10;
    public static final int MAX_NUMBER_OF_DRINKS = 2;
    private Map<String, Beverage> menu;

    public Pub() {
        menu = new HashMap<>();
        menu.put(ONE_BEER, new SimpleBeverage(74));
        menu.put(ONE_CIDER, new SimpleBeverage(103));
        menu.put(A_PROPER_CIDER, new SimpleBeverage(110));
        menu.put(GT, new Cocktail()
                            .withIngredient(IngredientUnit.GIN)
                            .withIngredient(IngredientUnit.TONIC_WATER)
                            .withIngredient(IngredientUnit.GREEN_STUFF));
        menu.put(BACARDI_SPECIAL, new Cocktail()
                            .withIngredient(IngredientUnit.GIN, 0.5)
                            .withIngredient(IngredientUnit.RUM)
                            .withIngredient(IngredientUnit.GRENADINE)
                            .withIngredient(IngredientUnit.LIME_JUICE));
    }

    public int computeCost(String drink, boolean student, int amount) {

        if (!menu.containsKey(drink)) {
            throw new RuntimeException("No such drink exists");
        }

        final Beverage beverage = menu.get(drink);

        if (amount > MAX_NUMBER_OF_DRINKS && beverage.isAmountLimited()) {
            throw new RuntimeException("Too many drinks, max " + MAX_NUMBER_OF_DRINKS);
        }

        int price = beverage.getPrice();

        if (student && beverage.isEligableForStudentDiscount()) {
            price = price - price / STUDENT_DISCOUNT;
        }

        return price*amount;
    }
}
