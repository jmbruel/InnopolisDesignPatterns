package pizzas;

public class PizzeriaRobby extends Pizzeria {
    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "4cheese":
                return new FourCheesesPizza();
            case "innopolis":
                return new InnopolisPizza();
            default:
                return null;
        }
    }
}
