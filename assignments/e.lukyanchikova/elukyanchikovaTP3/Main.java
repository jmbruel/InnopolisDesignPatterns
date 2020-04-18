package elukyanchikovaTP3;

public class Main {
    public static void main(String[] args) {
        PizzeriaStyleBrest pizzeriaStyleBrest = new PizzeriaStyleBrest();
        PizzeriaStyleStrasbourg pizzeriaStyleStrasbourg = new PizzeriaStyleStrasbourg();


        Pizza firstOrder = pizzeriaStyleBrest.orderPizza("pepperoni");
        Pizza secondOrder = pizzeriaStyleStrasbourg.orderPizza("vegetarian");
        System.out.println("Done cooking");
    }
}
