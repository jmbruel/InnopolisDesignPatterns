package pizzeria.implementations;

import pizza.Pizza;
import pizza.implementation.Bolognese;
import pizza.implementation.Calabrese;
import pizzeria.Pizzeria;

public class InnoPizza extends Pizzeria {

    @Override
    public Pizza create(String name){
        switch (name){
            case "Calabrese":
                return new Calabrese();
            case "Bolognese":
                return new Bolognese();
        }
        return new Calabrese();
    }
}