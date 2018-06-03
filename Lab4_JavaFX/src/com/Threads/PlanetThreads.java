package com.Threads;

public class PlanetThreads extends MainThread {
    //Thread planet;
    private int day;
    private int year = 0;
    private String planetName;

    private MainThread mainThread;

    public PlanetThreads(String name, MainThread mainThread){
        this.planetName=name;
        this.mainThread = mainThread;
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



    @Override
    public void run() {

        System.out.println(getPlanetName()+" Starting");
        try {
            while(day !=365)
            {
                sleep(100);
                setDay(day+1);


                System.out.println(getPlanetName()+" Good Morning!" + day);
                if(day !=0&& day %364 == 0) {
                    setYear(year+1);
                    System.out.println(getPlanetName() + " Happy New Year!" + day );
                }
            }
        }catch (InterruptedException exc){
            System.out.println(getPlanetName()+" interrupted");
        }
        System.out.println(getPlanetName()+" terminated");
    }

}
