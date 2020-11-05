package com.epam.automation.io.optionaltask.task1;

import java.io.*;
import java.util.*;

//Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
// При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

public class Solution {
    public static void main(String[] args) {
        Random random = new Random();
        String path = "src/main/resources/io/optionaltask/random-numbers/random-numbers.txt";
        List<Integer> listOfNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfNumbers.add(random.nextInt(50) + (-20));
        }

        createFileAndFolder();
        writeNumbersToFile(path, listOfNumbers);
        listOfNumbers = getNumbersFromFile(path);

        Collections.sort(listOfNumbers);

        writeNumbersToFile(path, listOfNumbers);

    }

    public static void createFileAndFolder() {
        File dir = new File("src/main/resources/io/optionaltask/random-numbers");
        dir.mkdir();
        File file = new File(dir, "random-numbers.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNumbersToFile (String path, List listOfNumbers) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < listOfNumbers.size(); i++) {
                bufferedWriter.write(listOfNumbers.get(i) + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getNumbersFromFile (String path) {
        List<Integer> listOfNumbersFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String[] arrayOfValues = bufferedReader.readLine().split(" ");

            for (int i = 0; i < arrayOfValues.length; i++) {
                listOfNumbersFromFile.add(Integer.parseInt(arrayOfValues[i]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfNumbersFromFile;
    }
}
