package com.epam.automation.collections.maintask.chef;

import com.epam.automation.collections.maintask.chef.vegetables.Vegetable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//4. Шеф-повар. Определить иерархию овощей. Сделать салат. Подсчитать калорийность.
// Провести сортировку овощей для салата на основе одного из параметров.
// Найти овощи в салате, соответствующие заданному диапазону калорийности.

public class Runner {

    public static void main( String[] args ) {
        Kitchen kitchen = new Kitchen();
        List<Vegetable> salad = kitchen.makeSalad();
        List<Vegetable> listOfvegetables;

        System.out.println("Общая калорийность салата - " + kitchen.countCalories(salad) + "kk" + "\n");

        System.out.println("Овощи в диапазоне заданной калорийности");
        listOfvegetables = kitchen.getVegetablesFromSaladWithCaloriesInterval(salad, 24, 30);
        for (Vegetable vegetable : listOfvegetables) {
            System.out.println(vegetable);
        }

        System.out.println();

        System.out.println("Sort by carbohydrate:");
        listOfvegetables = kitchen.sortByCarbohydrate(salad);
        for (Vegetable vegetable : listOfvegetables) {
            System.out.println(vegetable);
        }

    }

    public static List<String> readValuesFromFile(String filePath) {
        List<String> listValuesFromFile = new ArrayList<>();
        String lineFromFile;
        String[] arrayValuesFromFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                arrayValuesFromFile = lineFromFile.split(" ");
                listValuesFromFile.add(arrayValuesFromFile[1]);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        return listValuesFromFile;
    }



}
