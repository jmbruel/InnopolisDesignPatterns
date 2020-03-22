package weapons.impl;

import weapons.WeaponBehaviour;

public class DaggerBehaviour implements WeaponBehaviour {
    private static DaggerBehaviour instance = new DaggerBehaviour();

    private DaggerBehaviour() {
    }

    public static DaggerBehaviour getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Dagger stab!");
    }
}
