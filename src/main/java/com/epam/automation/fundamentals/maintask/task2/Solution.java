package com.epam.automation.fundamentals.maintask.task2;

//2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class Solution {

    public static void main( String[] args ) {

        for (int i = args.length-1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
