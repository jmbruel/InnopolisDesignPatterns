package pizzas;

import java.util.ArrayList;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparation of " + name);
        System.out.println("Making dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }
    public void cook() {
        System.out.println("Cook at 180° for 25 min.");
    }
    public void cut() {
        System.out.println("Cutting...");
    }
    public void wrap() {
        System.out.println("Wrapping...");
    }
    public String getName() {
        return name;
    }
}