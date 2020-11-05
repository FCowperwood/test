package com.epam.automation.fundamentals.optionaltask2.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//Задание. Ввести с консоли n - размерность матрицы a [n] [n].
// Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//3. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.

public class Solution {

    public static void main(String[] args) {
        Random random = new Random();
        int [][] matrix = null;
        int sumBetweenPositiveNumbers = 0;
        int numberOfLinesInTheMatrix = 0;
        int numberOfColumnsInTheMatrix = 0;
        int firstNumberOfDiapason = 0;
        int secondNumberOfDiapason = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите первое число (количество строк):");
            numberOfLinesInTheMatrix = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Введите второе число (количество столбцов):");
            numberOfColumnsInTheMatrix = Integer.parseInt(bufferedReader.readLine());

            matrix  = new int[numberOfLinesInTheMatrix][numberOfColumnsInTheMatrix];

            System.out.println("Введите первое число диапазона:");
            firstNumberOfDiapason = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Введите второе число диапазона:");
            secondNumberOfDiapason = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numberOfLinesInTheMatrix; i++) {
            for (int j = 0; j < numberOfColumnsInTheMatrix; j++) {
                matrix[i][j] = random.nextInt((secondNumberOfDiapason+1) - firstNumberOfDiapason) + firstNumberOfDiapason;
            }
        }

        for (int i = 0; i < numberOfLinesInTheMatrix; i++) {
            for (int j = 0; j < numberOfColumnsInTheMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < numberOfLinesInTheMatrix; i++) {
            for (int j = 0; j < numberOfColumnsInTheMatrix; j++) {
                if (matrix[i][j] > 0) {
                    for (int k = j+1; k < numberOfColumnsInTheMatrix; k++) {
                        if (matrix[i][k] < 0) {
                            sumBetweenPositiveNumbers += matrix[i][k];
                        } else if (matrix[i][k] > 0) {
                            k = numberOfColumnsInTheMatrix;
                        }
                    }

                    System.out.println("Сумма " + (i + 1) + " строки = " + sumBetweenPositiveNumbers);
                    sumBetweenPositiveNumbers = 0;
                    j = numberOfColumnsInTheMatrix;
                }

            }

        }

    }

}
