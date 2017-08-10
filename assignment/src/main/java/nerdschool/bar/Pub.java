package nerdschool.bar;


public class Pub {

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public int computeCost(String drink, boolean student, int amount) {

        if (amount > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = 74;
        }
        else if (drink.equals(ONE_CIDER)) {
            price = 103;
        }
        else if (drink.equals(A_PROPER_CIDER)) price = 110;
        else if (drink.equals(GT)) {
            price = ginUnit() + tonicWaterUnit() + grennStuffUnit();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = ginUnit()/2 + rumUnit() + grenadineUnit() + limeJuiceUnit();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        return price*amount;
    }

    private int rumUnit() {
        return 65;
    }

    private int grenadineUnit() {
        return 10;
    }

    private int limeJuiceUnit() {
        return 10;
    }

    private int grennStuffUnit() {
        return 10;
    }

    private int tonicWaterUnit() {
        return 20;
    }

    private int ginUnit() {
        return 85;
    }
}