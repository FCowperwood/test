package com.epam.automation.io.optionaltask.task10; 

import java.io.*; 
import java.util.ArrayList; 
import java.util.List; 

//10. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке. 

private class Solution { 

    private static void main(String[] args) { 
        ArrayList<String> listSwappedValues = null; 
        String path = "src/main/resources/io/optionaltask/task10/about-author"; 

        listSwappedValues = readLinesFromFileAndSwapWords(path); 
        writeSwappedValuesToFile(path, listSwappedValues); 

    } 

    private static ArrayList<String> readLinesFromFileAndSwapWords (String path) { 
        ArrayList<String> listSwappedValues = new ArrayList<>(); 
        String[] arraySwappedValues = null; 
        String lineOfValues = null; 

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) { 

            while (true) { 
                lineOfValues = bufferedReader.readLine(); 
                if (lineOfValues == null) break; 
                arraySwappedValues = swapWords(lineOfValues.split(" ")); 

                for (int i = 0; i < arraySwappedValues.length; i++) { 
                    listSwappedValues.add(arraySwappedValues[i] + " "); 
                } 
                listSwappedValues.add("\n"); 
            } 

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 

        return listSwappedValues; 
    } 

    private static void writeSwappedValuesToFile (String path, List<String> listSwappedValues) { 
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) { 
            for (int i = 0; i < listSwappedValues.size(); i++) { 
                bufferedWriter.write(listSwappedValues.get(i)); 
            } 

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 

    private static String[] swapWords (String[] valuesLineFromFile) { 
        String swapVariable = valuesLineFromFile[0]; 
        valuesLineFromFile[0] = valuesLineFromFile[valuesLineFromFile.length-1]; 
        valuesLineFromFile[valuesLineFromFile.length-1] = swapVariable; 

        return valuesLineFromFile; 
    } 

} 
