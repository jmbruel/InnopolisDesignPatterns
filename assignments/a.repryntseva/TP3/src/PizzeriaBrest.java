public class PizzeriaBrest extends Pizzeria {
    @Override
    public Pizza creerPizza(String type) {
        if (type.equals("fromage")) {
            return new BrestPizzaFromage();
        } else if (type.equals("grecque")) {
            return new BrestPizzaGrecque();
        } else {
            return new BrestPizzaPoivrons();
        }
    }
}
