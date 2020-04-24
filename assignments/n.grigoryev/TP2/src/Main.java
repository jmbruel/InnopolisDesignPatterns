import characters.implementation.King;
import characters.implementation.Troll;

public class Main {
    public static void main(String[] args) {
        King king = new King();
        Troll troll = new Troll();
        king.fight();
        troll.fight();
    }
}