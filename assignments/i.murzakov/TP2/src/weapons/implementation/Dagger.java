package weapons.implementation;

import weapons.Weapon;

public class Dagger implements Weapon {
    private static Dagger instance = new Dagger();

    private Dagger() {
    }

    public static Dagger getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Dagger stab!");
    }
}