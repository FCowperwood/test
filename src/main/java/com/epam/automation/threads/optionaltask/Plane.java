package com.epam.automation.threads.optionaltask;

import java.util.concurrent.Semaphore;

public class Plane extends Thread {

    private Semaphore runway;
    private String name;

    public Plane(Semaphore runway, String name) {
        this.runway = runway;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println("Полоса приняла самолет " + name);
            System.out.println("Самолет " + name + " начал выход на полосу" + "\n");
            Thread.sleep(3000);
            System.out.println("Самолет " + name + " взлетел");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            runway.release();
            System.out.println("Полоса освободилась");
        }

    }
}
