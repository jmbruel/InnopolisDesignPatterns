package characters;

import weapons.WeaponBehaviour;

abstract public class Character {
    private WeaponBehaviour weaponBehaviour;

    protected Character(WeaponBehaviour weaponBehaviour) {
        this.weaponBehaviour = weaponBehaviour;
    }

    public void setWeapon(WeaponBehaviour weaponBehaviour) {
        this.weaponBehaviour = weaponBehaviour;
    }

    public void fight() {
        weaponBehaviour.use();
    }


}
