package game.weapons;

public class Bow extends game.weapons.Weapon {
    private static Bow instance = new Bow();

    private Bow(){}

    public static Bow getInstance() {
        return instance;
    }

    @Override
    public String getWeaponName(){
        return "Bow";
    }
}
