package sources;

import sources.Characters.*;
import sources.Weapons.Dagger;
import sources.Weapons.Sword;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<CharacterU> game = new ArrayList<>();
        CharacterU firstKnight = new Knight(new Sword());
        CharacterU secondKnight = new Knight(new Dagger());
        CharacterU firstTrooll = new Troll();
        CharacterU secondTroll = new Troll();
        CharacterU thirdTrooll = new Troll();

        CharacterU king = King.getKingInstance();
        CharacterU queen = Queen.getQueenInstanse();

        game.add(firstKnight);
        game.add(secondKnight);
        game.add(firstTrooll);
        game.add(secondTroll);
        game.add(thirdTrooll);
        game.add(king);
        game.add(queen);


        for (CharacterU ch : game) {
            ch.attack();
        }

    }
}
