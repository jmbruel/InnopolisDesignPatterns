public class SimplePizzaFactory {

    public Pizza creePizza(String type) {
        Pizza pizza;

        if (type.equals("fromage")) {
            pizza = new StrasbourgPizzaFromage();
        } else if (type.equals("grecque")) {
            pizza = new StrasbourgPizzaGrecque();
        } else {
            pizza = new StrasbourgPizzaPoivrons();
        }

        return pizza;
    }


}
