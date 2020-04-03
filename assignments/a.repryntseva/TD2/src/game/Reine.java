package game;

public class Reine extends Personnage{
    private static Reine reine = new Reine();

    private Reine(){
        setArme(new ComportementEpee());
    }

    public static Reine getReine() {
        return reine;
    }
}
