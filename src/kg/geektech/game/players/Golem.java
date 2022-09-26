package kg.geektech.game.players;

public class Golem extends Hero {
    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.DAMAGE_ABSORBED);

    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != this && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + (boss.getDamage() / 5));
            }
        }
        this.setHealth(this.getHealth() - ((boss.getDamage() / 5) * (heroes.length - 1)));
        System.out.println("Damage absorbed by the Golem: " + ((boss.getDamage() / 5) * (heroes.length - 1)));
    }
}

