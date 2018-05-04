package com.game;

public class Quests {
    private String startQuest;
    private String finalQuest;

    Quests() {
        startQuest = "quest was started";
        finalQuest = "quest completed";
    }


    public String getFinalQuest() {
        return finalQuest;
    }

    public String getStartQuest() {
        return startQuest;
    }

    public void setFinalQuest(String finalQuest) {
        this.finalQuest = finalQuest;
    }

    public void setStartQuest(String startQuest) {
        this.startQuest = startQuest;
    }

    public String activateQuest(){
        return startQuest;
    }

    public String endQuest(){
        return finalQuest;
    }
}