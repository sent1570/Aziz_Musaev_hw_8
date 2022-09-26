package kg.geektech.game.players;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, name, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] != this) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }
            if (heroes[i] == heroes[heroes.length - 1]){
                System.out.println( "Medic " + this.getName() + " help " + healPoints + " to all players ");
            }
        }
    }
}
