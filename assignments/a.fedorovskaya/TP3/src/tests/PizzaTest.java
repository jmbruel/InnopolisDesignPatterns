package tests;

import creators.ChicagoPizzaFactory;
import creators.NYPizzaFactory;
import creators.Pizzeria;
import org.junit.jupiter.api.Test;
import products.Pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {
    @Test
    public void NYCheesePizzaTest(){
        Pizzeria pizzeria = new NYPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("cheese");

        assertEquals("NYCheese", pizza.getName());
    }

    @Test
    public void NYPepperoniPizzaTest(){
        Pizzeria pizzeria = new NYPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("pepperoni");

        assertEquals("NYPepperoni", pizza.getName());
    }

    @Test
    public void ChicagoCheesePizzaTest(){
        Pizzeria pizzeria = new ChicagoPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("cheese");

        assertEquals("ChicagoCheese", pizza.getName());
    }

    @Test
    public void ChicagoPepperoniPizzaTest(){
        Pizzeria pizzeria = new ChicagoPizzaFactory();

        Pizza pizza = pizzeria.orderPizza("pepperoni");

        assertEquals("ChicagoPepperoni", pizza.getName());
    }
}
