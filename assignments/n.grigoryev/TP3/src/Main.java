import pizzeria.implementations.InnoPizza;
import pizzeria.implementations.KazanPizza;

public class Main {
    public static void main(String[] args) {
        InnoPizza innoPizza = new InnoPizza();
        innoPizza.createPizza("Bolognese");

        KazanPizza kazanPizza = new KazanPizza();
        kazanPizza.createPizza("FourCheese");
        kazanPizza.createPizza("Bolognese");
    }
}