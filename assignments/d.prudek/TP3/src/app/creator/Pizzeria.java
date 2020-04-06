package app.creator;

import app.product.Pizza;

/**
 *
 * @author David Prudek
 */
public abstract class Pizzeria {
    
    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        
        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.pack();
        
        
        return pizza;
    }
    
    protected abstract Pizza createPizza(String type);
}
