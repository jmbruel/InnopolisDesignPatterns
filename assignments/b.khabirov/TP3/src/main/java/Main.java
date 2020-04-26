import pizzeria.BrooklynPizza;
import pizzeria.Cheeseria;
import pizzeria.Pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // this example demonstrates how using our factories (pizzerias)
        // one can order all pizzas from all pizzerias
        // without depending on implementations (dependency inversion!)

        // imagine these are all pizzerias available in Kazan
        List<Pizzeria> kazanPizzerias = new ArrayList<>();
        kazanPizzerias.add(new Cheeseria());
        kazanPizzerias.add(new BrooklynPizza());

        // and these are pizza kinds we want to order from every pizzeria
        List<Pizzeria.PizzaKind> kinds = new ArrayList<>();
        kinds.add(Pizzeria.PizzaKind.MARGARITA);
        kinds.add(Pizzeria.PizzaKind.PEPPERONI);

        // following piece of code does not depend on implementations
        kazanPizzerias.forEach(pizzeria -> {
            kinds.forEach(pizzeria::deliverPizza);
        });
    }
}
