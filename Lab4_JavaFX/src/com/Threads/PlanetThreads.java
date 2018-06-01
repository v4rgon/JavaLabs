package com.Threads;

public class PlanetThreads extends Thread {
    Thread planet;
    private int day;
    private int year = 0;
    private String planetName;
    private String gm = "Good Morning!";
    private String nw = "Happy New Year!";

    PlanetThreads(String name){
        planet = new Thread(this,name);
    }

    public void setPlanetName(String name) {
        this.planetName = name;
    }

    synchronized public String getPlanetName() {
        return planetName;
    }

    synchronized public int getDay() {
        return day;
    }

    synchronized public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    synchronized public String getGm() {
        return gm;
    }

    synchronized public String getNw() {
        return nw;
    }

    @Override
    public void run() {
        setPlanetName(planet.getName());
        System.out.println(planet.getName()+" Starting");
        try {
            while(day !=365)
            {
                setDay(day+1);
                Thread.sleep(1);
                System.out.println(planet.getName()+" Good Morning!" + day);
                if(day !=0&& day %364 == 0) {
                    setYear(year+1);
                    System.out.println(planet.getName() + " Happy New Year!" + day );
                }
            }
        }catch (InterruptedException exc){
            System.out.println(planet.getName()+" interrupted");
        }
        System.out.println(planet.getName()+" terminated");
    }
}
