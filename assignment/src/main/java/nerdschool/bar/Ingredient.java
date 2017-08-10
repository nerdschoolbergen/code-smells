package nerdschool.bar;

public enum Ingredient {


    RUM (65),
    GRENADINE(10),
    LIMEJUICE(10),
    GREENSTUFF(10),
    TONICWATER(20),
    GIN(85);

    Ingredient(int price) {
        this.price = price;
    }

    private int price;

    int getPrice() {
        return price;
    }
}
