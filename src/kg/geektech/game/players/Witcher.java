package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Witcher extends Hero {

    public Witcher(int health, String name) {
        super(health, name, SuperAbility.REANIMATION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
       int randomWitcher = RPG_Game.random.nextInt(2);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && randomWitcher == 1 && heroes[i] != this) {
                 heroes[i].setHealth(heroes[i].getHealth() + this.getHealth());
                 this.setHealth(this.getHealth() - this.getHealth());
                System.out.println("Witcher " + this.getName() + " resurrect " + heroes[i].getName());
                break;
            }
        }
    }
}