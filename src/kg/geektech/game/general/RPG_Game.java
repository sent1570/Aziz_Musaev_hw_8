package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;

    public static int getRoundNumber() {
        return roundNumber;
    }

    public static Random random = new Random();



    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Tanos");
        Warrior warrior = new Warrior(240, 10, "Nurbol");
        Medic doc = new Medic(240, 5, 10, "Kairat");
        Magic magic = new Magic(260, 20, "Ilyas");
        Berserk berserk = new Berserk(230, 15, "Aziz");
        Medic assistant = new Medic(230, 10, 5, "Abdulaziz");
        Golem golem = new Golem(500,5,"Islam");
        Witcher witcher = new Witcher(260,"Maksim");
        Hacker hacker = new Hacker(240,20,"Adilet");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant,golem,witcher,hacker};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }


    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
     boss.chooseDefence(heroes);
            boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getAbility() != boss.getDefence()
                    && heroes[i].getHealth() > 0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ---------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
