package app;

import app.characters.King;
import app.characters.Knight;
import app.characters.Queen;
import app.weapons.Dagger;
import app.weapons.Sword;

class Main{
    public static void main(String[] args) {
        King king = King.getInstance();
        Queen queen = Queen.getInstance();

        Knight knight1 = new Knight(new Dagger());
        Knight knight2 = new Knight(new Sword());

        king.battle();
        queen.battle();
        knight1.battle();
        knight2.battle();
    }
}
