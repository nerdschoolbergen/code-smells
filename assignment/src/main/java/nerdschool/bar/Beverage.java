package nerdschool.bar;

public abstract class Beverage {

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
}
