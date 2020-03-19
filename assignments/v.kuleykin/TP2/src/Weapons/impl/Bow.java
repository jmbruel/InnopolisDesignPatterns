package Weapons.impl;

import Weapons.WeaponBehavior;

public class Bow implements WeaponBehavior {

    private Bow() {
    }

    private static Bow instance = new Bow();

    public static Bow getInstance() {
        return instance;
    }


    @Override
    public String getWeaponName() {
        return "Bow";
    }
}
