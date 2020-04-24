package pizzas;

public abstract class Pizzeria {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.wrap();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
