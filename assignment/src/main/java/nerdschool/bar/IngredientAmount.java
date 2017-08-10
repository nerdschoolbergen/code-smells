package nerdschool.bar;

public class IngredientAmount {

    private final Ingredient ingredient;
    private final double amount;

    public IngredientAmount(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public int getPrice() {
        return (int) (ingredient.getPrice() * amount);
    }
}
