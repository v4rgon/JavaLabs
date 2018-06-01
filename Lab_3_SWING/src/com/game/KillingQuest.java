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

    public int killMonster(){
        if(monster.getDamage() == -1){
            monsterCount--;
            if (monsterCount==0) return 0;
            return 1;
        }

        return 0;
    }

    public String checkQuest() {
        if(monsterCount == 0) {
            return endQuest();
        }
        else {
            return "";
        }
    }
}
