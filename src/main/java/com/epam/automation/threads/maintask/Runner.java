package com.epam.automation.threads.maintask;

import java.util.ArrayList;
import java.util.List;

// Разработать консольное многопоточное приложение.
// Использовать возможности, предоставляемые пакетом java.util.concurrent.
// Все сущности, желающие получить доступ к ресурсу, должны быть потоками.

// 2. Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class Runner {

    public static void main(String[] args) {
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(new Parking("LA-001A"));
        parkingList.add(new Parking("LB-002B"));

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(parkingList, i)).start();
        }

    }
}
