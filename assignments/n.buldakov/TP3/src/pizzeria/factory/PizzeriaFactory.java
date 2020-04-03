package pizzeria.factory;

import pizzeria.Pizzeria;
import pizzeria.impl.PizzeriaBrest;
import pizzeria.impl.PizzeriaStrasbourg;

public class PizzeriaFactory {
    public Pizzeria creer(String nom) {
        switch (nom){
            case "Brest":
                return new PizzeriaBrest();
            case "Strasbourg":
                return new PizzeriaStrasbourg();
            default:
                return null;
        }
    }
}
