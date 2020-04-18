package pizza.factory.impl;

import pizza.Pizza;
import pizza.factory.PizzaFactory;
import pizza.impl.PizzaFromageStyleStrasbourg;
import pizza.impl.PizzaGrecqueStyleStrasbourg;
import pizza.impl.PizzaPoivronStyleStrasbourg;

public class PizzaFactoryStrasbourg extends PizzaFactory {
    @Override
    public Pizza creer(String nom) {
        switch (nom) {
            case "fromage":
                return new PizzaFromageStyleStrasbourg();
            case "grecque":
                return new PizzaGrecqueStyleStrasbourg();
            case "poivrons":
                return new PizzaPoivronStyleStrasbourg();
            default:
                return null;
        }
    }
}
