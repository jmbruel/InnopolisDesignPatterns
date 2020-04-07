package game.weapons;

public class Dagger extends game.weapons.Weapon {

    private static Dagger instance = new Dagger();

    private Dagger(){}

    public static Dagger getInstance() {
        return instance;
    }

    @Override
    public String getWeaponName(){
        return "Dagger";
    }
}
