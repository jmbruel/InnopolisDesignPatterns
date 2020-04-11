package pizzerias;

import pizzas.Pizza;

public abstract class Pizzeria {

    public final Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.wrap();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
