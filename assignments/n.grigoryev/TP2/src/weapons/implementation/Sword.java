package weapons.implementation;

import weapons.Weapon;

public class Sword implements Weapon {

    private static Sword instance = new Sword();

    private Sword() {
    }

    public static Sword getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Sword thrust!");
    }
}