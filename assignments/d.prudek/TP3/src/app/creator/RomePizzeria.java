package app.creator;

import app.product.HawaiiPizza;
import app.product.Pizza;
import app.product.QuattroFormaggiPizza;

/**
 *
 * @author David Prudek
 */
public class RomePizzeria extends Pizzeria {

    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "hawaii":
                return new HawaiiPizza();
            case "quattro_formaggi":
                return new QuattroFormaggiPizza();
            default:
                throw new UnsupportedOperationException("Invalid operation.");
        }
    }
    
    
}
