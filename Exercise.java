public class Exercise {
    
    public static void main (String[] args) {
        /* code */
        int[] numbers = {5,7,9,0,34,567,88,989,45,23}; 
    // Printing first and last element of the array   
    System.out.println(numbers[0]+ " is the first element of the array");
    System.out.println(numbers[numbers.length - 1] + " is the last element of the array");
    
    System.out.println(" Numbers array in reverse order");
    for(int i=numbers.length - 1; i>0;i--)
    {
        System.out.println(numbers[i]);
    }
        System.out.println(numbers.length +"  is the length of the numbers array");
    }

}
