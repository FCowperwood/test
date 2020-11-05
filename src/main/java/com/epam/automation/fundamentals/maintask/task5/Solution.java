package com.epam.automation.fundamentals.maintask.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

public class Solution {

    public static void main( String[] args ) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            switch (Integer.parseInt(bufferedReader.readLine())) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
                default:
                    System.out.println("Такого месяца не существует.");
                    break;
            }
        } catch (NumberFormatException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
