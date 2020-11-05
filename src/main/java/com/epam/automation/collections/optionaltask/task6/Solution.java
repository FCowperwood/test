package com.epam.automation.collections.optionaltask.task6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

public class Solution {

    public static void main(String[] args) {
        List<String> listOfValuesFromFile = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/collections/optionaltask/about-author"))) {
            String lineFromFile;

            while ((lineFromFile = bufferedReader.readLine()) != null) {

                String[] valuesLineFromFile = lineFromFile.split("[(),;:.!?\\s]+");
                for (int i = 0; i < valuesLineFromFile.length; i++) {
                    listOfValuesFromFile.add(valuesLineFromFile[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(listOfValuesFromFile);

        for (String valueFromList : listOfValuesFromFile) {
            System.out.println(valueFromList);
        }

    }
}
