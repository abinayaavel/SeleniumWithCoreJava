package main;

public class CoreJavaBrushup1 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 8, 10, 120, 78, 69 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i] + " is a even number");
            } else
                System.out.println(arr[i] + " is not a multiple of 2");
        }

    }
}
