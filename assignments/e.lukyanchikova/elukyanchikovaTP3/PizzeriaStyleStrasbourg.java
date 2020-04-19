package elukyanchikovaTP3;

public class PizzeriaStyleStrasbourg extends Pizzeria {

    @Override
    protected Pizza createPizza(String type) {

        if (type.equals("vegetarian")) {
            return new StrasbourgVegetarianPizza();
        } else if (type.equals("pepperoni")) {
            return new StrasbourgPepperroniPizza();
        }
        return null;
    }

}
