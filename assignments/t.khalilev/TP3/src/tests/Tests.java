package tests;

import main.pizza.Pizza;
import main.pizzeria.DoDoPizza;
import main.pizzeria.PapaJohnsPizza;
import main.pizzeria.Pizzeria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Tests {
    @Test
    public void DoDoPepperoniPizzaTest(){
        Pizzeria pizzeria = new DoDoPizza();

        Pizza pizza = pizzeria.deliverPizza("peperoni");

        assertEquals("DoDo pepperoni pizza", pizza.getName());
    }

    @Test
    public void DoDoSeaFoodPizzaTest(){
        Pizzeria pizzeria = new DoDoPizza();

        Pizza pizza = pizzeria.deliverPizza("seafood");

        assertEquals("DoDo sea food pizza", pizza.getName());
    }

    @Test
    public void DoDoDefaultPizzaTest(){
        Pizzeria pizzeria = new DoDoPizza();
        Pizza pizza = pizzeria.deliverPizza("def");
        assertEquals("Default pizza", pizza.getName());
    }

    @Test
    public void PapaJohnsPepperoniPizzaTest(){
        Pizzeria pizzeria = new PapaJohnsPizza();

        Pizza pizza = pizzeria.deliverPizza("pepperoni");

        assertEquals("Papa Johns pepperoni pizza", pizza.getName());
    }

    @Test
    public void PapaJohnsKiwiPizzaTest(){
        Pizzeria pizzeria = new PapaJohnsPizza();

        Pizza pizza = pizzeria.deliverPizza("kiwi");

        assertEquals("Papa Johns kiwi pizza", pizza.getName());
    }

    @Test
    public void PapaJohnsDefaultPizzaTest(){
        Pizzeria pizzeria = new PapaJohnsPizza();
        Pizza pizza = pizzeria.deliverPizza("def");
        assertEquals("Default pizza", pizza.getName());
    }






}