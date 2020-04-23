public class PizzeriaStrasbourg extends Pizzeria {
    @Override
    protected Pizza creerPizza(String type) {
        switch (type) {
            case "fromage":
                return new PizzaFromageStyleStrasbourg();
            case "grecque":
                return new PizzaGrecqueStyleStrasbourg();
//            case "saumon":
//                return new PizzaSaumonStyleStrasbourg();
//            case "royale":
//                return new PizzaRoyaleStyleStrasbourg();
//            case "vegetarienne":
//                return new PizzaVegetarienneStyleStrasbourg();
//            case "poivrons":
//                return new PizzaPoivronsStyleStrasbourg();
            default:
                throw new IllegalArgumentException("Unknown pizza type provided");
        }
    }
}
