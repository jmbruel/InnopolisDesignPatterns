public class Main {
    public static void main(String[] args) {
        // creating pizzerias
        PizzeriaBrest pizzeriaBrest = new PizzeriaBrest();
        PizzeriaStrasbourg pizzeriaStrasbourg = new PizzeriaStrasbourg();

        // ordering pizzas
        pizzeriaBrest.commanderPizza("fromage");
        pizzeriaStrasbourg.commanderPizza("fromage");
        pizzeriaStrasbourg.commanderPizza("vegeterian");
    }
}
