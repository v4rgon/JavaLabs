
package com.game;

public abstract class Monster {
    private String monsterType;
    private int monsterHealth;
    private int monsterLevel;
    KillingQuest killingQuest;

    public Monster(String name, int health, int level) {
        this.monsterType = name;
        this.monsterHealth = health;
        this.monsterLevel = level;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getMonsterLevel() {
        return monsterLevel;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public void setMonsterLevel(int monsterLevel) {
        this.monsterLevel = monsterLevel;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public void getDamage()
    {
        monsterHealth-=25;
        Die();
    }

    private void Die()
    {

        if(getMonsterHealth()<0)
        {
            if(getMonsterType()=="Werewolf")
            setMonsterHealth(150);
            else
                setMonsterHealth(50);
            killingQuest.setMonsterCount(killingQuest.getMonsterCount()-1);
        }
    }
}
