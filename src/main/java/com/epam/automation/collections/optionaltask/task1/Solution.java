package com.epam.automation.collections.optionaltask.task1;

import java.io.*;
import java.util.LinkedList;

//1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class Solution {

    public static void main( String[] args ) {
        LinkedList<String> listOfValuesFromFile = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/collections/optionaltask/about-author"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/collections/optionaltask/about-author-out"))) {
            String lineFromFile;

            while ((lineFromFile = bufferedReader.readLine()) != null) {
                String[] valuesLineFromFile = lineFromFile.split(" ");
                for (int i = valuesLineFromFile.length-1; i >= 0; i--) {
                    listOfValuesFromFile.add(valuesLineFromFile[i] + " ");
                }
                //listOfValuesFromFile.set(listOfValuesFromFile.size()-1, listOfValuesFromFile.get(listOfValuesFromFile.size()-1).trim());
                listOfValuesFromFile.set(listOfValuesFromFile.size()-1, listOfValuesFromFile.getLast().trim());
                listOfValuesFromFile.add("\n");
            }

            listOfValuesFromFile.removeLast();

            for (int i = 0; i < listOfValuesFromFile.size(); i++) {
                bufferedWriter.write(listOfValuesFromFile.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
