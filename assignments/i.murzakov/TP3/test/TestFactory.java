import org.junit.jupiter.api.Test;
import pizza.Pizza;
import pizzeria.Pizzeria;
import pizzeria.implementation.CacioeVino;
import pizzeria.implementation.InnoMax;

import static org.junit.Assert.assertEquals;


class TestFactory {
    @Test
    public void InnoMaxSardaTest(){
        Pizzeria pizzeria = new InnoMax();
        Pizza pizza = pizzeria.createPizza("Sarda");
        assertEquals("Sarda", pizza.getName());
    }

    @Test
    public void InnoMaxBologneseTest(){
        Pizzeria pizzeria = new InnoMax();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }

    @Test
    public void InnoMaxDefaultTest(){
        Pizzeria pizzeria = new InnoMax();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }


    @Test
    public void CacioeVinoSardaTest(){
        Pizzeria pizzeria = new CacioeVino();
        Pizza pizza = pizzeria.createPizza("Sarda");
        assertEquals("Sarda", pizza.getName());
    }

    @Test
    public void CacioeVinoBologneseTest(){
        Pizzeria pizzeria = new CacioeVino();
        Pizza pizza = pizzeria.createPizza("Bolognese");
        assertEquals("Bolognese", pizza.getName());
    }

    @Test
    public void CacioeVinoCalabreseTest(){
        Pizzeria pizzeria = new CacioeVino();
        Pizza pizza = pizzeria.createPizza("Calabrese");
        assertEquals("Calabrese", pizza.getName());
    }

    @Test
    public void CacioeVinoDefaultTest(){
        Pizzeria pizzeria = new CacioeVino();
        Pizza pizza = pizzeria.createPizza("Calabrese");
        assertEquals("Calabrese", pizza.getName());
    }
}
