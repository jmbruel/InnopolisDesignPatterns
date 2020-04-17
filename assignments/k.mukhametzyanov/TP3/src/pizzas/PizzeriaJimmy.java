package pizzas;

public class PizzeriaJimmy extends Pizzeria {
    @Override
    public Pizza createPizza(String type){
        switch (type){
            case "4cheese":
                return new FourCheesesPizza();
            case "hawaii":
                return new HawaiiPizza();
            default:
                return null;
        }
    }
}
