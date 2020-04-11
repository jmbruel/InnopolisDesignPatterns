import pizzas.Pizza;
import pizzerias.Pizzeria;
import pizzerias.PizzeriaBrest;
import pizzerias.PizzeriaStrasbourg;

public class Main {

    public static void main(String[] args) {
        Pizzeria boutiqueBrest = new PizzeriaBrest();
        Pizzeria boutiqueStrasbourg = new PizzeriaStrasbourg();

        Pizza pizza = boutiqueBrest.orderPizza("cheese");
        System.out.println("Client order is ready -  " + pizza.getName() + "\n");

        pizza = boutiqueStrasbourg.orderPizza("cheese");
        System.out.println("Client order is ready - " + pizza.getName() + "\n");
    }
}
