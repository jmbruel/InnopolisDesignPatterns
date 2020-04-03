package Weapons.impl;

import Weapons.WeaponBehavior;

public class Dagger implements WeaponBehavior {

    private Dagger() {
    }

    private static Dagger instance = new Dagger();

    public static Dagger getInstance() {
        return instance;
    }


    @Override
    public String getWeaponName() {
        return "Dagger";
    }
}
