package weapons.impl;

import weapons.WeaponBehaviour;

public class SwordBehaviour implements WeaponBehaviour {

    private static SwordBehaviour instance = new SwordBehaviour();

    private SwordBehaviour() {
    }

    public static SwordBehaviour getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Sword thrust!");
    }
}
