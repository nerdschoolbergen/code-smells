package nerdschool.bar;

public class Beverage {

    private String name;
    private int price;

    public Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Beverage fromIngredients(IngredientAmount... ingredientAmounts) {

        int price = 0;
        for (IngredientAmount ingredientAmount : ingredientAmounts) {
            price += ingredientAmount.getPrice();
        }
        return new Beverage("", price);
    }
}
