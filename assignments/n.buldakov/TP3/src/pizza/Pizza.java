package pizza;

import java.util.ArrayList;

/**
 * = Asciidoclet
 *
 * Sample comments that include `source code` by mailto:jbruel@gmail.com[JMB].
 *
 * [source,java]
 * --
 * include::src/java/pizzeria.Pizzeria/src/pizza.Pizza.java[lines=14..34]
 * --
 *
 * @author bruel
 *
 */
public abstract class Pizza {
    protected String nom;
    protected String pate;
    protected String sauce;
    protected ArrayList<String> garnitures = new ArrayList<String>();

    public void preparer() {
        System.out.println("Préparation de " + nom);
        System.out.println("Étalage de la pâte...");
        System.out.println("Ajout de la sauce...");
        System.out.println("Ajout des garnitures: ");
        for (String garniture : garnitures) {
            System.out.println(" " + garniture);
        }
    }
    public void cuire() {
        System.out.println("Cuisson 25 minutes à 180°");
    }
    public void couper() {
        System.out.println("Découpage en parts triangulaires");
    }
    public void emballer() {
        System.out.println("Emballage dans une boîte officielle");

    }
    public String getNom() {
        return nom;
    }
}
