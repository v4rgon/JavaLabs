
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

    public int getDamage()
    {
        if(getMonsterHealth()>0)
        {
            setMonsterHealth(monsterHealth-25);


            if(getMonsterHealth()==0)
            {
                Die();
                return -1;
            }
            return 0;

        }
        return 0;
    }

    private int Die()
    {

            if(getMonsterType()=="Werewolf")
            setMonsterHealth(150);
            else
                setMonsterHealth(50);
            return -1;

    }
}
