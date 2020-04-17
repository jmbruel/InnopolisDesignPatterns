package pizza.factory.impl;

import pizza.Pizza;
import pizza.factory.PizzaFactory;
import pizza.impl.PizzaFromageStyleBrest;
import pizza.impl.PizzaGrecqueStyleBrest;
import pizza.impl.PizzaPoivronStyleBrest;

public class PizzaFactoryBrest extends PizzaFactory {
    @Override
    public Pizza creer(String nom) {
        switch (nom) {
            case "fromage":
                return new PizzaFromageStyleBrest();
            case "grecque":
                return new PizzaGrecqueStyleBrest();
            case "poivrons":
                return new PizzaPoivronStyleBrest();
            default:
                return null;
        }
    }


}
