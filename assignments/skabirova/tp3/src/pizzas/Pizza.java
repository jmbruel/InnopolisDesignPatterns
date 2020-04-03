package pizzas;

import java.util.ArrayList;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println("Preparation of " + name);
        System.out.println("Make dough...");
        System.out.println("Add sauce...");
        System.out.println("Add toppings");
        for(int i = 0; i < toppings.size(); i++){
            System.out.println(toppings.get(i));
        }
    }

    public void cook(){
        System.out.println("Cook at 180 for 25 min");
    }

    public void cut(){
        System.out.println("Cutting");
    }

    public void wrap(){
        System.out.println("Wrapping");
    }

    public String getName(){
        return name;
    }
}
