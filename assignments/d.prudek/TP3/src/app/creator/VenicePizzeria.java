package app.creator;

import app.product.Pizza;
import app.product.QuattroFormaggiPizza;
import app.product.SalamiPizza;

/**
 *
 * @author David Prudek
 */
public class VenicePizzeria extends Pizzeria {

    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "salami":
                return new SalamiPizza();
            case "quattro_formaggi":
                return new QuattroFormaggiPizza();
            default:
                throw new UnsupportedOperationException("Invalid operation.");
        }
    }
    
    
}
