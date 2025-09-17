package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {
        /* code */
        int[] numbers = { 5, 7, 9, 0, 34, 567, 88, 989, 45, 23 };
        // Printing first and last element of the array
        System.out.println(numbers[0] + " is the first element of the array");
        System.out.println(numbers[numbers.length - 1] + " is the last element of the array");

        System.out.println(" Numbers array in reverse order");
        for (int i = numbers.length - 1; i > 0; i--) {
            System.out.println(numbers[i]);
        }
        System.out.println(numbers.length + "  is the length of the numbers array");

        List<String> aList = new ArrayList<String>();
        aList.add("hello");
        aList.add("hai");
        aList.add("how");
        aList.add("are");
        aList.add("you");

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }
        System.out.println("*******************");

        String[] name = { "abi", "anu", "bala", "kiki", "daya", "arun", "kumar" };
        List<String> StringArray = Arrays.asList(name);
        for (String s : StringArray) {
            System.out.println(s);
        }

    }

}
