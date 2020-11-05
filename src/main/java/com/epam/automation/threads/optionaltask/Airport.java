package com.epam.automation.threads.optionaltask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

// В аэропорту есть 5 взлетно-посадочных полос. Самолету требуется 3 минуты чтобы выйти на полосу, набрать скорость и взлететь.
// После этого полоса свободна для вылета следующего самолета. Реализовать симуляцию вылета 10 самолетов используя все доступные полосы.
// 1 минуту реально времени заменить на 1 секунду в симуляции. Вывести в консоль информацию о следующих событиях:
// самолет начал выход на полосу, самолет взлетел, полоса "приняла" самолет, полоса освободилась.

public class Airport {

    public static void main(String[] args) {
        Semaphore runways = new Semaphore(5, true);
        List<Plane> planesForDeparture = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            planesForDeparture.add(new Plane(runways, "Plane " + i));
        }

        for (Plane plane : planesForDeparture) {
            plane.start();
        }

    }

}
