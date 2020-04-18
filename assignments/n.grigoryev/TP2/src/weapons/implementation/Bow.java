package weapons.implementation;

import weapons.Weapon;

public class Bow implements Weapon {

    private static Bow instance = new Bow();

    private Bow() {
    }

    public static Bow getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Bow shoots!");
    }
}