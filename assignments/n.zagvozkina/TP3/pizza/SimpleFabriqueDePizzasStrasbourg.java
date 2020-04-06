package pizza;

public class SimpleFabriqueDePizzasStrasbourg extends SimpleFabriqueDePizzas {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza=null;

        switch (type) {
            case "fromage":
                pizza = new PizzaFromageStrasbourg();
                break;
            case "royale":
                pizza = new PizzaRoyaleStrasbourg();
                break;
            default:
                pizza = new PizzaVegetarienne();
                break;
        }

        return pizza;
    }

}