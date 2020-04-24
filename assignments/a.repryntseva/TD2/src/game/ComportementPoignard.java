package game;

public class ComportementPoignard implements ComportementArme {
    @Override
    public void utiliserArme() {
        System.out.println("Je frappe avec un poignard!");
    }
}
