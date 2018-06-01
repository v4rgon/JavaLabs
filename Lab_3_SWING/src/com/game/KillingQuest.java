package com.game;

public class KillingQuest extends  Quests {
    private Monster monster;
    private int monsterCount;

    public KillingQuest(Monster monster, int monsterCount) {
        this.monster = monster;
        this.monsterCount = monsterCount;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void killMonster(){
        monster.getDamage();
    }

    public void checkQuest() {
        if(monsterCount == 0) {
            return questComplete();
        }
        else return "";
    }
}
