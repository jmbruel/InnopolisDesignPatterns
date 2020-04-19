package pizza;

import pizza.Pizza;

public class PizzaVegetarienne extends Pizza {
    public PizzaVegetarienne() {
        nom = "Pizza vegetarienne";
        pate = "Pâte épaisse";
        sauce = "Sauce Choucroute";
        garnitures.add("Mozzarella en lamelles");
        garnitures.add("Choucroutte");
    }
}
