package com.epam.automation.io.maintask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies".
// Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F.

//Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше - прочитать файл и
// вывести в консоль следующие данные:

// Количество папок
// Количество файлов
// Среднее количество файлов в папке
// Среднюю длинну названия файла

public class Solution {

    public static void main(String[] args) {
        List<String> valuesFromFile;
        int[] numberOfFilesAndFolders;
        String path = args[0];
        //String path = "src/main/resources/io/maintask/Amon Amarth.txt";
        //String path = "f:/";

        if (path.contains(".txt")) {

            valuesFromFile = readFromFile(path);
            numberOfFilesAndFolders = countNumberOfFilesAndFolders(valuesFromFile);
            System.out.println("Среднее количество файлов в папке составляет: " + numberOfFilesAndFolders[1] / numberOfFilesAndFolders[0]);
            countAverageFileNameLength(valuesFromFile, numberOfFilesAndFolders[1]);
        } else {

            File file = new File(path + "/Amon Amarth");
            file.mkdir();
            createFilesAndFolders(path + "/Amon Amarth/");
        }

    }

    public static void createFilesAndFolders (String path) {
        String lineFromFile = null;
        File dir = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/io/maintask/Amon Amarth.txt"))) {

            while ((lineFromFile = bufferedReader.readLine()) != null) {

                if (!lineFromFile.contains(".mp3")) {
                    dir = new File(path + lineFromFile);
                    dir.mkdir();

                    System.out.println(lineFromFile);
                } else {
                    File file = new File(dir, lineFromFile);
                    file.createNewFile();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> readFromFile (String path) {
        List<String> listOfLines = new ArrayList<>();
        String lineFromFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            while ((lineFromFile = bufferedReader.readLine()) != null) {

                listOfLines.add(lineFromFile);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfLines;
    }

    public static int[] countNumberOfFilesAndFolders(List<String> valuesFromFile) {
        int[] array = new int[2];
        int folderCounter = 0;
        int fileCounter = 0;

        for (String element : valuesFromFile) {
            if (!element.contains(".mp3") && !element.isEmpty()) {
                folderCounter++;
            } else if (element.contains(".mp3")) {
                fileCounter++;
            }
        }

        array[0] = folderCounter;
        array[1] = fileCounter;

        System.out.println("Folders " + folderCounter);
        System.out.println("Files " + fileCounter);

        return array;
    }

    public static void countAverageFileNameLength(List<String> valuesFromFile, int numberOfFiles) {
        int sumOfFileLengths = 0;

        for (String value : valuesFromFile) {
            if (value.contains(".mp3")) {
                sumOfFileLengths = sumOfFileLengths + value.length();
            }
        }

        System.out.println("Средняя длина названия файла составляет: " + sumOfFileLengths / numberOfFiles);
    }


}
