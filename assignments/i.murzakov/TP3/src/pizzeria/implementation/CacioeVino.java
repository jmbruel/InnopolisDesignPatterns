package pizzeria.implementation;

import pizza.Pizza;
import pizza.implementation.Bolognese;
import pizza.implementation.Calabrese;
import pizza.implementation.Sarda;
import pizzeria.Pizzeria;

public class CacioeVino extends Pizzeria {

    @Override
    public Pizza create(String name){
        switch (name){
            case "Sarda":
                return new Sarda();
            case "Calabrese":
                return new Calabrese();
            case "Bolognese":
                return new Bolognese();
        }
        return new Calabrese();
    }
}