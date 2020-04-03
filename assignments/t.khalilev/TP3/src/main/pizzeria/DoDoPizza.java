package main.pizzeria;

import main.pizza.DefaultPizza;
import main.pizza.DoDoPepperoniPizza;
import main.pizza.DoDoSeaFoodPizza;
import main.pizza.Pizza;

public class DoDoPizza extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("peperoni")){
            return new DoDoPepperoniPizza();
        }
        else if(type.equals("seafood")){
            return new DoDoSeaFoodPizza();
        }
        else{
            return new DefaultPizza();
        }
    }
}
