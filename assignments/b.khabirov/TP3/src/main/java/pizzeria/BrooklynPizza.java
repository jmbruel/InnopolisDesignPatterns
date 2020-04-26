package pizzeria;

import pizza.Pizza;
import pizza.BrooklynPepperoniPizza;
import pizza.BrooklynMargaritaPizza;

public class BrooklynPizza extends Pizzeria {
    @Override
    Pizza createPizza(PizzaKind kind) {
        Pizza pizza = null;

        switch (kind) {
            case MARGARITA:
                pizza = new BrooklynMargaritaPizza();
                break;
            case PEPPERONI:
                pizza = new BrooklynPepperoniPizza();
                break;
        }

        return pizza;
    }
}
