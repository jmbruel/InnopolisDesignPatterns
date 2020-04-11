package main;

import main.pizzeria.DoDoPizza;
import main.pizzeria.PapaJohnsPizza;
import main.pizzeria.Pizzeria;

public class Main {
    public static void main(String[] args) {
        Pizzeria papajohns= new PapaJohnsPizza();

        papajohns.deliverPizza("pepperoni");
        papajohns.deliverPizza("kiwi");
        papajohns.deliverPizza("");


        Pizzeria dodo = new DoDoPizza();
        dodo.deliverPizza("pepperoni");
        dodo.deliverPizza("seafood");
        dodo.deliverPizza("default");

    }
}
