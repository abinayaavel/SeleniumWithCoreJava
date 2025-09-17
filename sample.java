package main;

import java.util.Map;
import java.util.stream.Collectors;

public class sample {

    public static void main(String[] args) {

        // get("Hello Wowhrld");
        getUsingStreams("Hello Wowhrld");
    }

    private static void getUsingStreams(String input) {

        input.replaceAll(" ", "");

        Map<Character, Long> values = input.toLowerCase().chars().mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        values.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static void get(String input) {

        // List<Character> charList = input.chars().collect(Collectors.toList());

        char[] charList = input.toLowerCase().toCharArray();
        boolean[] b = new boolean[input.length()];

        for (int i = 0; i < charList.length; i++) {
            if (b[i])
                continue;

            // System.out.println(charList[i]);

            int count = 1;
            for (int j = i + 1; j < charList.length; j++) {
                if (charList[i] == charList[j]) {

                    count++;
                    b[j] = true;
                }
            }
            System.out.println(charList[i] + " = " + count);
        }
    }

}
