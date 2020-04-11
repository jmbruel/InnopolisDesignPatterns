import main.pizzeria.DodoPizzeria;
import main.pizzeria.InnomaxPizzeria;
import main.pizzeria.Pizzeria;

public class Main {

    public static void main(String[] args) {
        Pizzeria dodoPizza = new DodoPizzeria();
        Pizzeria innoMax = new InnomaxPizzeria();

        dodoPizza.orderPizza("Hawaiian");
        dodoPizza.orderPizza("Cheese");

        innoMax.orderPizza("Hawaiian");
        innoMax.orderPizza("Cheese");

    }
}