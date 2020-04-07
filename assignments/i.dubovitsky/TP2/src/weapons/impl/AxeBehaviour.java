package weapons.impl;

import weapons.WeaponBehaviour;

public class AxeBehaviour implements WeaponBehaviour {

    private static AxeBehaviour instance = new AxeBehaviour();

    private AxeBehaviour() {
    }

    public static AxeBehaviour getInstance() {
        return instance;
    }

    @Override
    public void use() {
        System.out.println("Axe blow!");
    }
}
