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
            price = ingredient6() + ingredient5() + ingredient4();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = ingredient6()/2 + ingredient1() + ingredient2() + ingredient3();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        return price*amount;
    }

    //one unit of rum
    private int ingredient1() {
        return 65;
    }

    //one unit of grenadine
    private int ingredient2() {
        return 10;
    }

    //one unit of lime juice
    private int ingredient3() {
        return 10;
    }
    
    //one unit of green stuff
    private int ingredient4() {
        return 10;
    }

    //one unit of tonic water
    private int ingredient5() {
        return 20;
    }

    //one unit of gin
    private int ingredient6() {
        return 85;
    }
}
