public class PizzeriaStrasbourg extends Pizzeria {
    @Override
    public Pizza creerPizza(String type) {
        switch (type) {
            case "fromage":
                return new StrasbourgPizzaFromage();
            case "grecque":
                return new StrasbourgPizzaGrecque();
            case "vegeterian":
                return new StrasbourgPizzaVeg();
            default:
                return new StrasbourgPizzaPoivrons();
        }
    }
}
