package pizzeria.implementations;

import pizza.Pizza;
import pizza.implementation.Bolognese;
import pizza.implementation.FourCheese;
import pizzeria.Pizzeria;

public class KazanPizza extends Pizzeria {

    @Override
    public Pizza create(String name){
        switch (name){
            case "FourCheese":
                return new FourCheese();
            case "Bolognese":
                return new Bolognese();
        }
        return new Bolognese();
    }
}