public class PizzeriaBrest extends Pizzeria {
    @Override
    protected Pizza creerPizza(String type) {
        switch (type) {
            case "fromage":
                return new PizzaFromageStyleBrest();
            case "grecque":
                return new PizzaGrecqueStyleBrest();
//            case "saumon":
//                return new PizzaSaumonStyleBrest();
//            case "royale":
//                return new PizzaRoyaleStyleBrest();
//            case "vegetarienne":
//                return new PizzaVegetarienneStyleBrest();
//            case "poivrons":
//                return new PizzaPoivronsStyleBrest();
            default:
                throw new IllegalArgumentException("Unknown pizza type provided");
        }
    }
}
