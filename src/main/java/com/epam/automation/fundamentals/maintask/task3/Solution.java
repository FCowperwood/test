package com.epam.automation.fundamentals.maintask.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.

public class Solution {

    public static void main( String[] args ) {
        Random random = new Random();
        int quantityNumbers = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество случайных чисел");
            quantityNumbers = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arrayOfRandomNumbers = new int[quantityNumbers];

        for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
            arrayOfRandomNumbers[i] = random.nextInt(1000);
        }

        for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
            System.out.print(arrayOfRandomNumbers[i] + " ");
            //System.out.println(arrayOfRandomNumbers[i]);

        }

    }
}
