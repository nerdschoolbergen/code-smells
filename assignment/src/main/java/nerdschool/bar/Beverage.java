package nerdschool.bar;

public class Beverage {

    private int price;
    private boolean isAmountLimited;

    public Beverage(int price, boolean isAmountLimited) {
        this.price = price;
        this.isAmountLimited = isAmountLimited;
    }


    public int getPrice() {
        return price;
    }

    public boolean isAmountLimited() {
        return isAmountLimited;
    }

    public static Beverage fromIngredients(IngredientAmount... ingredientAmounts) {

        int price = 0;
        for (IngredientAmount ingredientAmount : ingredientAmounts) {
            price += ingredientAmount.getPrice();
        }
        return new Beverage(price, true);
    }
}
