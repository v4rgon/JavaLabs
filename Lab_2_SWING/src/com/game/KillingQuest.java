package com.game;

public class KillingQuest extends  Quests {
    private String monster;
    private int monsterCount;
    private Hero hero;

    KillingQuest(String monster, int monsterCount) {
        this.monster = monster;
        this.monsterCount = monsterCount;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void killMonster(){
        --monsterCount;
    }

    public String checkQuest() {
        if(monsterCount == 0) {
            return  endQuest();
        }
        else {
            return "";
        }
    }
}