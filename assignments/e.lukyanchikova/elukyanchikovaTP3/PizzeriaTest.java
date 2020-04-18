package elukyanchikovaTP3;

import org.junit.Assert;
import org.junit.Test;

public class PizzeriaTest {
    @Test
    public void StrasbourgVegetarianPizzaTest() {
        PizzeriaStyleStrasbourg pizzeria = new PizzeriaStyleStrasbourg();
        Pizza pizza = pizzeria.orderPizza("vegetarian");
        Assert.assertEquals("StrasbourgVegetarian", pizza.getPizzaName());
    }

    @Test
    public void StrasbourgPepperoniPizzaTest() {
        PizzeriaStyleStrasbourg pizzeria = new PizzeriaStyleStrasbourg();
        Pizza pizza = pizzeria.orderPizza("pepperoni");
        Assert.assertEquals("StrasbourgPepperoni", pizza.getPizzaName());
    }

    @Test
    public void BrestPepperoniPizzaTest() {
        PizzeriaStyleBrest pizzeria = new PizzeriaStyleBrest();
        Pizza pizza = pizzeria.orderPizza("pepperoni");
        Assert.assertEquals("BrestPepperoni", pizza.getPizzaName());
    }

    @Test
    public void BrestVegetarianPizzaTest() {
        PizzeriaStyleBrest pizzeria = new PizzeriaStyleBrest();
        Pizza pizza = pizzeria.orderPizza("vegetarian");
        Assert.assertEquals("BrestVegetarian", pizza.getPizzaName());
    }
}
