package test;

import org.junit.jupiter.api.*;
import pizzas.CheeseBrestPizza;
import pizzas.GreekBrestPizza;
import pizzas.Pizza;
import pizzerias.PizzeriaBrest;
import pizzerias.PizzeriaStrasbourg;

public class TestTP3 {
    @Test
    void testPizza1(){
        PizzeriaBrest pizzeriaBrest = new PizzeriaBrest();
        Pizza pizza = pizzeriaBrest.createPizza("cheese");
        Assertions.assertEquals("Cheese Brest Style Pizza", pizza.getName());
    }
    @Test
    void testPizza2(){
        PizzeriaBrest pizzeriaBrest = new PizzeriaBrest();
        Pizza pizza = pizzeriaBrest.createPizza("greek");
        Assertions.assertEquals("Greek Brest Style Pizza", pizza.getName());
    }
    @Test
    void testPizza3(){
        PizzeriaStrasbourg pizzeriaStrasbourg = new PizzeriaStrasbourg();
        Pizza pizza = pizzeriaStrasbourg.createPizza("cheese");
        Assertions.assertEquals("Cheese Strasbourg Style Pizza", pizza.getName());
    }
    @Test
    void testPizza4(){
        PizzeriaStrasbourg pizzeriaStrasbourg = new PizzeriaStrasbourg();
        Pizza pizza = pizzeriaStrasbourg.createPizza("greek");
        Assertions.assertEquals("Greek Strasbourg Style Pizza", pizza.getName());
    }
}
