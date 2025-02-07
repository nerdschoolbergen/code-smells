package nerdschool.bar;

public class Pub {
    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    private static final Map<String, Integer> DRINK_PRICES = Map.of(
        ONE_BEER, 74,
        ONE_CIDER, 103,
        A_PROPER_CIDER, 110
    );

    private static final Map<String, Integer> INGREDIENT_PRICES = Map.of(
        "rum", 65,
        "grenadine", 10,
        "lime juice", 10,
        "green stuff", 10,
        "tonic water", 20,
        "gin", 85
    );

    public int computeCost(String drink, boolean student, int amount) {
        if (amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))) {
            throw new RuntimeException("Too many drinks, max 2.");
        }

        int price = getDrinkPrice(drink);

        if (student && isEligibleForStudentDiscount(drink)) {
            price -= price / 10; // 10% discount
        }
        return price * amount;
    }

    private int getDrinkPrice(String drink) {
        if (DRINK_PRICES.containsKey(drink)) {
            return DRINK_PRICES.get(drink);
        } else if (drink.equals(GT)) {
            return INGREDIENT_PRICES.get("gin") + INGREDIENT_PRICES.get("tonic water") + INGREDIENT_PRICES.get("green stuff");
        } else if (drink.equals(BACARDI_SPECIAL)) {
            return (INGREDIENT_PRICES.get("gin") / 2) + INGREDIENT_PRICES.get("rum") +
                   INGREDIENT_PRICES.get("grenadine") + INGREDIENT_PRICES.get("lime juice");
        } else {
            throw new RuntimeException("No such drink exists");
        }
    }

    private boolean isEligibleForStudentDiscount(String drink) {
        return drink.equals(ONE_CIDER) || drink.equals(ONE_BEER) || drink.equals(A_PROPER_CIDER);
    }
}
