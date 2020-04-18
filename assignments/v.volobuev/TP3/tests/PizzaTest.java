import sites.ItalianPizzaFactory;
import sites.NYPizzaFactory;
import sites.Pizzeria;
import org.junit.Test;
import menu.Pizza;

import static org.junit.Assert.assertEquals;

public class PizzaTest {
    @Test
    public void NYCheesePizzaTest(){
        Pizzeria pizzeria = new NYPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("cheese");

        assertEquals("New York Cheese pizza", pizza.getName());
    }

    @Test
    public void ChicagoPepperoniPizzaTest(){
        Pizzeria pizzeria = new ItalianPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("cheese");

        assertEquals("Italian Cheese pizza", pizza.getName());
    }
}
