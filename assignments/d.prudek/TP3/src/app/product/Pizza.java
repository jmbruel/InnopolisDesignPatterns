package app.product;

import java.util.ArrayList;

/**
 *
 * @author David Prudek
 */
public abstract class Pizza {
    String name;
    String paste;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparation of " + name);
        System.out.println("Spreading the dough...");
        System.out.println("Adding the sauce...");
        System.out.println("Adding of toppings: ");
        
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i)); 
        }
    }
    public void cook() {
        System.out.println("Cooking 25 minutes at 180 °");
    }
    public void cut() {
        System.out.println("Cutting into triangular parts");
    }
    public void pack() {
        System.out.println("Packed!");

    }
    public String getName() {
        // TODO sdfksadhfjk
        return name;
    }
}
