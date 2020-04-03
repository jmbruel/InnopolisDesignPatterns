import characters.impl.King;
import characters.impl.Troll;

public class Main{
    public static void main(String[] args) {
        Troll troll = new Troll();
        King king = new King();
        troll.fight();
        king.fight();

    }
}