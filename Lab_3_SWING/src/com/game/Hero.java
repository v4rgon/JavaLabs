package com.game;

public class Hero {
    private String Race;
    private String Specialization ;
    private int Level;
    private Location location = null;
    private KillingQuest killingQuest;
    private TravelQuest travelQuest;

    public Hero(){
        this.Race = "Human";
        this.Specialization="Archer";
        this.Level =1;
        this.location = new Location(1,1);
    }

    //public Hero(String _race,String _spec,int _lev,int _X,int _Y){
    //    this.Race =_race;
    //    this.Specialization =_spec;
     //   this.Level =_lev;
     //   this.location = new Location(_X, _Y);
   // }

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

    public int getLocationX(){
        return location.getX();
    }

    public int getLocationY() {
        return location.getY();
    }

    public  void setLocation(int _x, int _y){
        this.location = new Location(_x,_y);
    }

    public String getQuest() {
        int count =1;
        if(count == 2) {
            return killingQuest.activateQuest();
        }

        if(count == 1) {
            count++;
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