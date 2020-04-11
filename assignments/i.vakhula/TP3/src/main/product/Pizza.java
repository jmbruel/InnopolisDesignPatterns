package main.product;

public abstract class Pizza {

    String name;
    String sauce;

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Adding sauce " + sauce);
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official Pizzeria box");
    }

    public String getName() {
        return this.name;
    }
}
