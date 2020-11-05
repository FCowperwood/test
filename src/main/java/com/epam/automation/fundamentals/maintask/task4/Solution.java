package com.epam.automation.fundamentals.maintask.task4;

//4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

public class Solution {

    public static void main( String[] args ) {

        int multiplicationOfEnteredNumbers = 1;

        for (int i = 0; i < args.length; i++) {
            multiplicationOfEnteredNumbers *=  Integer.parseInt(args[i]);
        }
        System.out.println("Multiplication of all entered numbers is equal: " + multiplicationOfEnteredNumbers);
    }
}
