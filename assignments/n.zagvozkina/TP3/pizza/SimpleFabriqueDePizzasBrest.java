package pizza;

public class SimpleFabriqueDePizzasBrest extends SimpleFabriqueDePizzas {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza=null;

        switch (type) {
            case "fromage":
                pizza = new PizzaFromageBrest();
                break;
            case "royale":
                pizza = new PizzaRoyaleBrest();
                break;
            default:
                pizza = new PizzaVegetarienne();
                break;
        }

        return pizza;
    }

}