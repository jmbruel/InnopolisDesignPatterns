package pizzeria.implementation;

import pizza.Pizza;
import pizza.implementation.Bolognese;
import pizza.implementation.Sarda;
import pizzeria.Pizzeria;

public class InnoMax extends Pizzeria {

    @Override
    public Pizza create(String name){
        switch (name){
            case "Sarda":
                return new Sarda();
            case "Bolognese":
                return new Bolognese();
        }
        return new Bolognese();
    }
}