package com.game;

public class TravelQuest extends Quests{
    private Location location;
    private float time;

     public TravelQuest(Location _locate, float _time) {
        location = _locate;
        time = _time;
    }

    public float getTime() {
        return time;
    }

    public int getLocationX() {
        return location.getX();
    }

    public int getLocationY(){
        return location.getY();
    }

    public  void setLocation(int _x,int _y){
        this.location = new Location(_x,_y);
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String checkCordinates(Location place){
        if(place.getX() == location.getX() && place.getY() == location.getY()) {
            return endQuest();
        }
        return "";
    }
}
