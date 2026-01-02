package org.ooprpg;

public class Unit {
    private String name;
    private int hp;
    private int hpMax;
    private int attack;
    private int defence;
    private float critAttackChance;
    private boolean defStance;

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Unit(String name, int hpMax, int attack, int defence) {
        this.name = name;
        this.hpMax = hpMax;
        this.hp = this.hpMax;
        this.attack = attack;
        this.defence = defence;
        this.critAttackChance = 0.2f;
    }

    public void attack(Unit target) {
        int actualAttack = attack;
        if (Math.random() <= critAttackChance) {
            actualAttack *= 2;
        }
        int resultedAttackAmount = target.takeDamage(actualAttack);
        System.out.println("Персонаж " + name + " наносит врагу " + target.name + " " + resultedAttackAmount + " ед. урона");
        target.printInfo();
    }

    public void defenceStance() {
        defStance = true;
        System.out.println(name + " защищается");
    }

    public void beginTurn() {
        System.out.println();
        System.out.println("Ход персонажа: " + name);
        printInfo();
        defStance = false;
    }

    public int takeDamage(int amount) {
        int actualDefence = defence;
        if (defStance) {
            actualDefence *= 1.5f;
        }
        amount -= actualDefence;
        if (amount < 0) {
            amount = 0;
        }
        hp -= amount;
        return amount;
    }

    public void cure(int amount) {
        hp += amount;
        if (hp < hpMax) {
            hp = hpMax;
        }
    }

    public void printInfo() {
        System.out.println(name + " HP: " + hp + "/" + hpMax + " ATTACK:" + attack + " DEFSTANCE: " + defStance);
    }

}
