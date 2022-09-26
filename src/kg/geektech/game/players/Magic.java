package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int MagicBoost = RPG_Game.random.nextInt(5) + 5;
        boss.setHealth(boss.getHealth() + MagicBoost);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getDamage() != 0) {
                heroes[i].setDamage(heroes[i].getDamage() + MagicBoost);
            }
            if (heroes[i] == heroes[heroes.length - 1]) {
                System.out.println("Magic " + this.getName() + " boost " + MagicBoost + " to all players");
            }
        }
    }
}
