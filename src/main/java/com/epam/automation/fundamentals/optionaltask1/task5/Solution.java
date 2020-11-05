package com.epam.automation.fundamentals.optionaltask1.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//5. Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

public class Solution {

    public static void main(String[] args) throws IOException {

        List<Integer> mainListEnteredNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> evenAndOddNumbers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String enteredNumber;

            while (!(enteredNumber = bufferedReader.readLine()).isEmpty()) {
                    mainListEnteredNumbers.add(Integer.parseInt(enteredNumber));

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mainListEnteredNumbers.size(); i++) {

            char [] charArray = mainListEnteredNumbers.get(i).toString().toCharArray();
            int counterForEvenAndOddNumbers = 0;
            int charArrayLength = charArray.length;

            if (charArray[0] == '-') charArrayLength--;

            for (int j = 0; j < charArray.length; j++) {
                if (Character.getNumericValue(charArray[j]) % 2 == 0) counterForEvenAndOddNumbers++;

            }

            if (counterForEvenAndOddNumbers == charArrayLength) {
                evenNumbers.add(mainListEnteredNumbers.get(i));
            } else if (counterForEvenAndOddNumbers == (double)charArrayLength/2) {
                evenAndOddNumbers.add(mainListEnteredNumbers.get(i));
            }
        }

        System.out.println("Числа полностью состоящие из четных цифр: " + evenNumbers.size() + "шт.");
        System.out.println(evenNumbers + "\n");
        System.out.println("Числа состоящие из четных и нечетных цифр 50/50: " + evenAndOddNumbers.size() + "шт.");
        System.out.println(evenAndOddNumbers);

    }

}
