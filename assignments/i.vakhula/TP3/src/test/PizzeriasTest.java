package test;

import main.creator.Pizzeria;
import main.creator.PizzeriaBrest;
import main.creator.PizzeriaStrasbourg;
import main.product.Pizza;
import main.product.PizzaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PizzeriasTest {

    private Pizzeria pizzeria;

    @Test
    void orderBrestPizza() {
        this.pizzeria = new PizzeriaBrest();

        Map<PizzaType, String> brestPizzaNames = Map.ofEntries(
                Map.entry(PizzaType.CHEESE, "BrestCheese"),
                Map.entry(PizzaType.PEPPERONI, "BrestPepperoni"),
                Map.entry(PizzaType.VEGGIE, "BrestVeggie")
        );

        Pizza pizza;
        for (PizzaType pizzaType : PizzaType.values()) {
            pizza = this.pizzeria.orderPizza(pizzaType);
            Assertions.assertEquals(brestPizzaNames.get(pizzaType), pizza.getName());
        }
    }

    @Test
    void orderStrasbourgPizza() {
        this.pizzeria = new PizzeriaStrasbourg();

        Map<PizzaType, String> brestPizzaNames = Map.ofEntries(
                Map.entry(PizzaType.CHEESE, "StrasbourgCheese"),
                Map.entry(PizzaType.PEPPERONI, "StrasbourgPepperoni"),
                Map.entry(PizzaType.VEGGIE, "StrasbourgVeggie")
        );

        Pizza pizza;
        for (PizzaType pizzaType : PizzaType.values()) {
            pizza = this.pizzeria.orderPizza(pizzaType);
            Assertions.assertEquals(brestPizzaNames.get(pizzaType), pizza.getName());
        }
    }

}
