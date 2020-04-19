package elukyanchikovaTP3;

public class PizzeriaStyleBrest extends Pizzeria {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("vegetarian")) {
            return new BrestVegetarianPizza();
        } else if (type.equals("pepperoni")) {
            return new BrestPepperoniPizza();
        }
        return null;
    }
}
