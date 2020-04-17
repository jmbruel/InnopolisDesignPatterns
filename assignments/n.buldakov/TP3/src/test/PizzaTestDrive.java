package test;

import pizza.Pizza;
import pizzeria.Pizzeria;
import pizzeria.factory.PizzeriaFactory;
import pizzeria.impl.PizzeriaBrest;
import pizzeria.impl.PizzeriaStrasbourg;

public class PizzaTestDrive {
    public static void main(String[] args) {
        Pizzeria boutiqueBrest = new PizzeriaFactory().creer("Brest");
        Pizzeria boutiqueStrasbourg = new PizzeriaFactory().creer("Strasbourg");

        Pizza pizza = boutiqueBrest.commanderPizza("fromage");
        System.out.println("JMB a commandé une " + pizza.getNom() + "\n");

        pizza = boutiqueStrasbourg.commanderPizza("fromage");
        System.out.println("JMI a commandé une " + pizza.getNom() + "\n");
    }
}