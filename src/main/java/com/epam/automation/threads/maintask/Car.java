package com.epam.automation.threads.maintask;

import java.util.List;

public class Car implements Runnable {

    private List<Parking> parkingList;
    private int id;

    public Car(List<Parking> parkingList, int id) {
        this.parkingList = parkingList;
        this.id = id;
    }

    @Override
    public void run() {
        
        Parking parking = null;

        try {

            for (int i = 0; i < parkingList.size(); i++) {
                parking = parkingList.get(i);
                parking.parkingArea.acquire();

                if (parkTheCar(parking)) i = parkingList.size();

            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parking.parkingArea.release();
        }

    }

    public boolean parkTheCar(Parking parking) throws InterruptedException {

        boolean isTheCarParked = false;
        int search = 0;

        System.out.println("Автомобиль № " + id + " въехал на территорию стоянки " + parking.getName() + " и принялся искать место");
        Thread.sleep(3000);

        while (search < 2) {

            synchronized (parking.getPlaces()) {

                boolean[] places = parking.getPlaces();
                for (int i = 0; i < places.length; i++) {

                    if (places[i] == false) { //if the current place is free

                        places[i] = true;
                        isTheCarParked = true;
                        System.out.println("Автомобиль № " + id + " выбрал место для парковки " + i + "A" + " и включил сигнализацию");

                        if (id == 3) {
                            places[i] = false;
                            System.out.println("Водитель автомобиля № " + id + " забыл ключи от квартиры на работе...");
                        }

                        i = places.length;
                        search = 2;
                    }

                }
            }

            if (isTheCarParked == false && search == 1) {
                System.out.println("У водителя автомобиля № " + id + " лопнуло терпение и он уехал на другую стоянку");

            } else if (!isTheCarParked) {
                Thread.sleep(2000);
                System.out.println("Автомобиль № " + id + " кружит по стоянке " + parking.getName() + " в поиски свободного места");
            }

            search++;

        }

        return isTheCarParked;
    }

}
