package nerdschool.bar;

public class Cocktail implements Beverage {

    private int price;

    @Override
    public int getPrice() {
        return price;
    }

    public Cocktail withIngredient(IngredientUnit ingredientUnit) {
        return withIngredient(ingredientUnit, 1);
    }

    public Cocktail withIngredient(IngredientUnit ingredientUnit, double amount) {
        price += (ingredientUnit.getPrice() * amount);
        return this;
    }

    public boolean isAmountLimited() {
        return true;
    }

    @Override
    public boolean isEligableForStudentDiscount() {
        return false;
    }
}
