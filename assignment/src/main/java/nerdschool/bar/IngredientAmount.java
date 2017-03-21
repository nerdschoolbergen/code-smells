package nerdschool.bar;

/**
 * Created by karianneberg on 21/03/17.
 */
public class IngredientAmount {
    private final Pub.Ingredient ingredient;
    private final double amount;

    public IngredientAmount(Pub.Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public int getPrice() {
        return (int) (ingredient.getPrice() * amount);
    }
}
