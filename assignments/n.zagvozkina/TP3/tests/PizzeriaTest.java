package tests;

import pizza.Pizza;
import pizza.SimpleFabriqueDePizzasBrest;
import pizza.SimpleFabriqueDePizzasStrasbourg;

public class PizzeriaTest {
    public static void main(String[] args) {
        SimpleFabriqueDePizzasBrest boutiqueBrest = new SimpleFabriqueDePizzasBrest();
        SimpleFabriqueDePizzasStrasbourg boutiqueStrasbourg = new SimpleFabriqueDePizzasStrasbourg();

        Pizza pizza = boutiqueBrest.createPizza("");
        System.out.println("JMB a commandé une " + pizza.getNom() + "\n");

        pizza = boutiqueStrasbourg.createPizza("");
        System.out.println("JMI a commandé une " + pizza.getNom() + "\n");
    }
}