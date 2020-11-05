package com.epam.automation.threads.maintask;

import java.util.concurrent.Semaphore;

public class Parking {

    Semaphore parkingArea = new Semaphore(3, true);
    private boolean[] places = new boolean[3];
    private String name;

    public Parking(String name) {
        this.name = name;
    }

    public boolean[] getPlaces() {
        return places;
    }

    public String getName() {
        return name;
    }
}
