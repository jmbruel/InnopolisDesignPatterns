import pizzeria.implementation.CacioeVino;
import pizzeria.implementation.InnoMax;

public class Main {
    public static void main(String[] args) {
        InnoMax innoMax = new InnoMax();
        innoMax.createPizza("Sarda");
        innoMax.createPizza("Bolognese");
        innoMax.createPizza("Maybe Bolognese?");

        CacioeVino cacioeVino = new CacioeVino();
        cacioeVino.createPizza("Sarda");
        cacioeVino.createPizza("Bolognese");
        cacioeVino.createPizza("vegetarienne");
    }
}