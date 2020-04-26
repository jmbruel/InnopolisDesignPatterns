import pizza.Pizza;
import pizzeria.BrooklynPizza;
import pizzeria.Cheeseria;
import pizzeria.Pizzeria;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PizzeriaTest {
    @Test
    public void testBrooklynPepperoniPizza() {
        // given
        Pizzeria pizzeria = new BrooklynPizza();

        // when
        Pizza pizza = pizzeria.deliverPizza(Pizzeria.PizzaKind.PEPPERONI);

        // then
        assertEquals("Brooklyn pepperoni pizza", pizza.getName());
    }

    @Test
    public void testBrooklynMargaritaPizza() {
        // given
        Pizzeria pizzeria = new BrooklynPizza();

        // when
        Pizza pizza = pizzeria.deliverPizza(Pizzeria.PizzaKind.MARGARITA);

        // then
        assertEquals("Brooklyn margarita (best in town!)", pizza.getName());
    }

    @Test
    public void testCheeseriaPepperoniPizza() {
        // given
        Pizzeria pizzeria = new Cheeseria();

        // when
        Pizza pizza = pizzeria.deliverPizza(Pizzeria.PizzaKind.PEPPERONI);

        // then
        assertEquals("Cheeseria pepperoni pizza", pizza.getName());
    }

    @Test
    public void testCheeseriaMargaritaPizza() {
        // given
        Pizzeria pizzeria = new Cheeseria();

        // when
        Pizza pizza = pizzeria.deliverPizza(Pizzeria.PizzaKind.MARGARITA);

        // then
        assertEquals("Cheeseria margarita pizza", pizza.getName());
    }
}