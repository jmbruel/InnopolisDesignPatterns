import pizzerias.Pizzeria;
import pizzerias.impl.PizzeriaBrest;
import pizzerias.impl.PizzeriaStrasbourg;
import pizzas.Pizza;

public class PizzeriaTest {
    public static void main(String[] args) {
        Pizzeria boutiqueBrest = new PizzeriaBrest();
        Pizzeria boutiqueStrasbourg = new PizzeriaStrasbourg();

        Pizza pizza = boutiqueBrest.orderPizza("cheese");
        System.out.println("JMB order is ready: " + pizza.getName() + "\n");

        pizza = boutiqueStrasbourg.orderPizza("greek");
        System.out.println("JMI order is ready: " + pizza.getName() + "\n");
    }
}