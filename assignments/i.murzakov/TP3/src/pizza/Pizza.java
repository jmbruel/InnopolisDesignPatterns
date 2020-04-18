package pizza;

import java.util.ArrayList;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;

    protected ArrayList<String> ingredients = new ArrayList<>();

    public void prepare(){
        System.out.println("Preparation of " + name);
        System.out.println("Make dough...");
        System.out.println("Add sauce...");
        System.out.println("Add toppings...");

        for(String ingredient: ingredients){
            System.out.println("Add " + ingredient);
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