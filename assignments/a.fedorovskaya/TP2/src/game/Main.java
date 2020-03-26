package game;

import game.characters.King;
import game.characters.Knight;
import game.characters.Queen;
import game.weapons.Dagger;
import game.weapons.Sword;

class Main{
    public static void main(String[] args) {
        King king = King.getInstance();
        Queen queen = Queen.getInstance();

        Knight knight1 = new Knight(new Sword());
        Knight knight2 = new Knight(new Dagger());

        king.battle();
        queen.battle();
        knight1.battle();
        knight2.battle();
    }
}