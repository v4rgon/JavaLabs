package com.game;

public class TravelQuest extends Quests{
    private Location location;
    private float time;

    TravelQuest() {
        location = new Location(45,12);
        time = 12.5f;
    }

    public float getTime() {
        return time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String checkCordinates(Location place){
        if(place.getX() == location.getX() && place.getY() == location.getY()) {
            return endQuest();
        }

        else {
            return "";
        }
    }
}