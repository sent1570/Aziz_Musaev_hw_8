package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero {
    int randomHacker;
    int randomHacker1;

    public Hacker(int health,int damage, String name) {
        super(health,damage, name, SuperAbility.HACK);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int counter2 = 0;
        for (int i = 0; i <heroes.length ; i++) {
          if (heroes[i].getHealth() > 0) {
              counter2 = counter2 + 1;
          }
        }

        while (true) {
            if (counter2 > 0) {
                 randomHacker = RPG_Game.random.nextInt(heroes.length);
                 randomHacker1 = RPG_Game.random.nextInt(30) + 20;
                if (RPG_Game.getRoundNumber() % 2 != 0) {
                   if (heroes[randomHacker] != this && heroes[randomHacker].getHealth() > 0){
                        boss.setHealth(boss.getHealth() - randomHacker1);
                        heroes[randomHacker].setHealth(heroes[randomHacker].getHealth() + randomHacker1);
                        System.out.println(randomHacker1 + " points from Boss to " + heroes[randomHacker].getName());
                        break;
                    }
                continue;
                }
                break;
            }
        }

    }

    public int count1(Hero[] heroes) {
        int counter2 = 0;
        for (int i = 0; i < heroes.length; i++) {
if (heroes[i].getHealth() > 0){
    counter2 = counter2 + 1;
}
        }
        return counter2;
    }
}

