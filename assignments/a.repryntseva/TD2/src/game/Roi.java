package game;

public class Roi extends Personnage {
    private static Roi roi = new Roi();

    private Roi(){
        setArme(new ComportementEpee());
    }

    public static Roi getRoi() {
        return roi;
    }
}
