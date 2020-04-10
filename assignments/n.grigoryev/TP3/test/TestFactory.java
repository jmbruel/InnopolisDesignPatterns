import org.junit.jupiter.api.Test;
import pizza.Pizza;
import pizzeria.Pizzeria;
import pizzeria.implementations.InnoPizza;
import pizzeria.implementations.KazanPizza;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestFactory {
    @Test
    public void KazanPizzaFourCheeseTest(){
        Pizzeria pizzeria = new KazanPizza();
        Pizza pizza = pizzeria.createPizza("FourCheese");
        assertEquals("FourCheese", pizza.getName());
    }

    @Test
    public void InnoPizzaBologneseTest(){
        Pizzeria pizzeria = new InnoPizza();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }

    @Test
    public void InnoPizzaDefaultTest(){
        Pizzeria pizzeria = new InnoPizza();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }

    @Test
    public void KazanPizzaBologneseTest(){
        Pizzeria pizzeria = new KazanPizza();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }
}