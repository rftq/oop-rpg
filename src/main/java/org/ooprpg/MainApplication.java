package org.ooprpg;

public class MainApplication {
    public static void main(String[] args) {
        Unit hero = new Unit("Jack", 30, 4,2);
        Unit monster = new Unit("Goblin", 20, 5,1);


        hero.beginTurn();
        hero.attack(monster);

        monster.beginTurn();
        monster.attack(hero);


        System.out.println("Герой идёт по подземелью и наступает в ловушку");
        hero.takeDamage(5);

//        hero.setName("Bob"); // вызов сеттера
//        System.out.println(hero.getName()); // вызов геттера
    }


}