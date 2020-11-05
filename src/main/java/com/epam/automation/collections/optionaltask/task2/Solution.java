package com.epam.automation.collections.optionaltask.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

public class Solution {

    public static void main(String[] args) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> listOfNumbersInReverseOrder = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String enteredNumber;

            while (!(enteredNumber = bufferedReader.readLine()).isEmpty()) {
                stack.push(Integer.parseInt(enteredNumber));
            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        while (stack.peek() != null) {

            int numberFromStack = stack.pop();
            char[] stackNumberChar = String.valueOf(numberFromStack).toCharArray();
            boolean isReverseOrder = true;

            for (int i = 0; i < stackNumberChar.length-1; i++) {

                if (stackNumberChar[i] <= stackNumberChar[i+1]) {
                    isReverseOrder = false;
                    break;
                }
            }
            if (isReverseOrder) listOfNumbersInReverseOrder.add(numberFromStack);
        }

        System.out.println(listOfNumbersInReverseOrder);

    }
}
