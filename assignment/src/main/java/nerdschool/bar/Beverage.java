package nerdschool.bar;

/**
 * Created by karianneberg on 20/03/17.
 */
public class Beverage {
    private int price;
    private boolean isAmountLimited;

    public Beverage(int price) {
        this.price = price;
    }

    private Beverage(int price, boolean isAmountLimited) {
        this(price);
        this.isAmountLimited = isAmountLimited;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAmountLimited() {
        return isAmountLimited;
    }

    public static Beverage withAmountLimiting(int price) {
        return new Beverage(price, true);
    }

    public static Beverage fromIngredients(IngredientAmount... ingredientAmounts) {
        int ingredientPrice = 0;
        for (IngredientAmount ingredient :
                ingredientAmounts) {
            ingredientPrice += ingredient.getPrice();
        }

        return new Beverage(ingredientPrice, true);
    }
}
