package game;

public class Main {
    public static void main(String[] args) {
        Chevalier c1 = new Chevalier();
        c1.combattre();

        Chevalier c2 = new Chevalier();
        c2.combattre();

        Reine reine = Reine.getReine();
        reine.combattre();

        Roi roi = Roi.getRoi();
        roi.combattre();
    }
}
