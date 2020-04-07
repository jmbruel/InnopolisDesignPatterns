package comportements.impl;

import comportements.ComportementArme;

public class ComportementArc implements ComportementArme {
    private static ComportementArc instance = new ComportementArc();
    @Override
    public void utiliseArme() {
        System.out.print("I draw my bow very far.");
    }
    public static ComportementArc getInstance() {
        return instance;
    }
}
