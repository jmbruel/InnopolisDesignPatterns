import sites.ItalianPizzaFactory;
import sites.NYPizzaFactory;
import sites.Pizzeria;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new NYPizzaFactory();
        pizzeria.orderPizza("cheese");
        pizzeria.orderPizza("pepperoni");

        Pizzeria pizzeria1 = new ItalianPizzaFactory();
        pizzeria1.orderPizza("cheese");
        pizzeria1.orderPizza("pepperoni");
    }
}
