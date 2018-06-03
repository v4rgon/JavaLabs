package com.Threads;

import java.util.LinkedList;

public class MainThread extends Thread {
    private LinkedList<Thread> threads = new LinkedList<Thread>();
    private String gm = "Good Morning!";
    private String nw = "Happy New Year!";
    private String pln;

    MainThread(){
        this.threads = new LinkedList<Thread>();
    }

    public void createPlanet(String name) {
        threads.add(new Thread(new PlanetThreads(name,this)));
        this.pln = name;
    }

    synchronized public String getGm() {
        return gm;
    }

    synchronized public String getNw() {
        return nw;
    }

    public String getPln() {
        return pln;
    }

    public void start() {
        for(Thread t : threads) {
            t.start();
        }
    }
}
