package com.game;

public class Hero {
    private String Race;
    private String Specialization ;
    private int Level;
    private Location location;
    private KillingQuest killingQuest = new KillingQuest("zerg", 20);
    private TravelQuest travelQuest = new TravelQuest();

    public Hero(String _race,String _spec,int _lev,int _X,int _Y){
        this.Race =_race;
        this.Specialization =_spec;
        this.Level =_lev;
        this.location = new Location(_X, _Y);
    }

    public String getRace(){
        return Race;
    }
    public String getSpecialization(){
        return Specialization;
    }

    public void setRace(String race) {
        Race = race;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        this.Level = level;
    }

    public String getQuest(char ch) {

        if(ch == 'k') {
            return killingQuest.activateQuest();
        }

        if(ch == 't') {
            return travelQuest.activateQuest();
        }

        return "";
    }

    public void travel(Location _place) {
        while(location.getX() > _place.getX()) {
            location.setX(location.getX() - 1);
        }

        while(location.getY() > _place.getY()) {
            location.setY(location.getY() - 1);
        }

        while(location.getX() < _place.getX()) {
            location.setX(location.getX() + 1);
        }

        while(location.getY() < _place.getY()) {
            location.setY(location.getY() + 1);
        }
    }
}