package Weapons.impl;

import Weapons.WeaponBehavior;

public class Sword implements WeaponBehavior {

    private Sword() {
    }

    private static Sword instance = new Sword();

    public static Sword getInstance() {
        return instance;
    }


    @Override
    public String getWeaponName() {
        return "Sword";
    }
}
