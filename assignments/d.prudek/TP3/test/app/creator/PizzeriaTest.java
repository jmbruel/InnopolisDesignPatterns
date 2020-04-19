package app.creator;

import app.product.Pizza;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author David Prudek
 */
public class PizzeriaTest {
    
    @Test
    public void testOrderPizza() {
        Pizzeria rome = new RomePizzeria();

        Pizza pizza1 = rome.orderPizza("hawaii");
        Pizza pizza2 = rome.orderPizza("hawaii");
        
        assertNotEquals(pizza1, pizza2);
        assertEquals(pizza1.getName(), pizza2.getName());
        
    }
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
 
    
    @Test
    public void testOrderPizzaExeption() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Invalid operation.");
        
        Pizzeria rome = new RomePizzeria();

        Pizza pizza1 = rome.orderPizza("salami");
        
        Pizzeria venice = new VenicePizzeria();

        Pizza pizza2 = venice.orderPizza("hawaii");
        
    }
    
}
