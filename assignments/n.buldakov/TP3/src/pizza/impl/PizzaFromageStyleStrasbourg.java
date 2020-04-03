package pizza.impl;

import pizza.Pizza;

public class PizzaFromageStyleStrasbourg extends Pizza {
    public PizzaFromageStyleStrasbourg() {
        nom = "pizza.Pizza pâte style Strasbourg et fromage";
        pate = "Extra épaisse";
        sauce = "Sauce tomate";
        garnitures.add("Mozzarella en lamelles"); }
    public void couper() {
        System.out.println("Découpage en parts carrées");
    }
}
