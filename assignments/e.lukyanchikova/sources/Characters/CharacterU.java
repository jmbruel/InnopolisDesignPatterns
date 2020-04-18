package sources.Characters;

import sources.Weapons.Weapon;

public abstract class CharacterU {
   private Weapon weapon;

   protected CharacterU(){}
    public CharacterU(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(){
        System.out.print(this.getClass().getSimpleName() +" is ");
        this.weapon.attackWith();
    }


}
