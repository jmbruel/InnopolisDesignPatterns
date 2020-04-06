package tests;

import pizzas.Pizza;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pizzas.Pizzeria;
import pizzas.PizzeriaJimmy;
import pizzas.PizzeriaRobby;

class Tests {
    @Test
    public void RobbyPizzeriaFourCheesesPizzaTest(){
        Pizzeria pizzeria = new PizzeriaRobby();
        Pizza pizza = pizzeria.orderPizza("4cheese");
        assertEquals("4 cheeses", pizza.getName());
    }

    @Test
    public void RobbyPizzeriaInnopolisPizzaTest(){
        Pizzeria pizzeria = new PizzeriaRobby();
        Pizza pizza = pizzeria.orderPizza("innopolis");
        assertEquals("Pizza from Innopolis with love!", pizza.getName());
    }

    @Test
    public void JimmyPizzeriaFourCheesesTest(){
        Pizzeria pizzeria = new PizzeriaJimmy();
        Pizza pizza = pizzeria.orderPizza("4cheese");
        assertEquals("4 cheeses", pizza.getName());
    }

    @Test
    public void JimmyPizzeriaHawaiiTest(){
        Pizzeria pizzeria = new PizzeriaJimmy();
        Pizza pizza = pizzeria.orderPizza("hawaii");
        assertEquals("Hawaii", pizza.getName());
    }
}
