import pizza.SimpleFabriqueDePizzasBrest;
import pizza.SimpleFabriqueDePizzasStrasbourg;

public class Main {
    public static void main(String[] args) {
        SimpleFabriqueDePizzasStrasbourg pizzeriaStrasbourg = new SimpleFabriqueDePizzasStrasbourg();
        pizzeriaStrasbourg.createPizza("fromage");
        pizzeriaStrasbourg.createPizza("royale");
        pizzeriaStrasbourg.createPizza("vegetarienne");

        SimpleFabriqueDePizzasBrest pizzeriaBrest = new SimpleFabriqueDePizzasBrest();
        pizzeriaBrest.createPizza("fromage");
        pizzeriaBrest.createPizza("royale");
        pizzeriaBrest.createPizza("vegetarienne");
    }
}
