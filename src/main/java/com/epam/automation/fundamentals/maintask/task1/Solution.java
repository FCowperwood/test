package com.epam.automation.fundamentals.maintask.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1. Приветствовать любого пользователя при вводе его имени через командную строку.

public class Solution {

    public static void main( String[] args ) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("What's your name?");
            String name = bufferedReader.readLine();
            System.out.println("Hello, " + name + "!" + " Welcome!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
