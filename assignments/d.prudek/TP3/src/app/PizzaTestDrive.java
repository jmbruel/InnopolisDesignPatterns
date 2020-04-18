package app;

import app.creator.Pizzeria;
import app.creator.RomePizzeria;
import app.creator.VenicePizzeria;
import app.product.Pizza;

/**
 *
 * @author David Prudek
 */
public class PizzaTestDrive {
    
    public static void main(String[] args) {
        Pizzeria rome = new RomePizzeria();
        Pizzeria venice = new VenicePizzeria();

        Pizza pizza1 = rome.orderPizza("hawaii");
        System.out.println("JMB a commandé une " + pizza1.getName() + "\n");
        
        Pizza pizza2 = venice.orderPizza("quattro_formaggi");
        System.out.println("JMB a commandé une " + pizza2.getName() + "\n");
        
      

    }
    
}
