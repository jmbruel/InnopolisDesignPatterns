package elukyanchikovaTP3;

public abstract class Pizzeria {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);
        pizza.prepare();
        pizza.cook();
        pizza.pack();
        pizza.deliver();

        return pizza;
    }

    abstract Pizza createPizza(String type) ;

}
