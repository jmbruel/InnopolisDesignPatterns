package pizzeria;

import pizza.CheeseriaMargaritaPizza;
import pizza.CheeseriaPepperoniPizza;
import pizza.Pizza;

public class Cheeseria extends Pizzeria {
    @Override
    Pizza createPizza(PizzaKind kind) {
        Pizza pizza = null;

        switch (kind) {
            case MARGARITA:
                pizza = new CheeseriaMargaritaPizza();
                break;
            case PEPPERONI:
                pizza = new CheeseriaPepperoniPizza();
                break;
        }

        return pizza;
    }
}
