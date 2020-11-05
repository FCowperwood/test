package com.epam.automation.collections.optionaltask.task5;

import java.util.Arrays;
import java.util.List;

//5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 345, 23, -32, 99, 6, 12, -12, -101, -10345, 60, 28, 34, 125, 123, 22, -2322);
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) < list.get(i+1)) {
                    flag = true;
                                                                // a = 2; b = 3
                    list.set(i, list.get(i) + list.get(i+1));   // a = a + b  5
                    list.set(i+1, list.get(i) - list.get(i+1)); // b = a - b  2
                    list.set(i, list.get(i) - list.get(i+1));   // a = a - b  3
                                                                // a = 3; b = 2

                    //int swapVariable = list.get(i);
                    //list.set(i, list.get(i+1));
                    //list.set(i+1, swapVariable);

                }
            }
        }

        System.out.println(list);
    }
}
