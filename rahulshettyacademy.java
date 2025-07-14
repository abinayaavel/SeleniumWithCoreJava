public class rahulshettyacademy {
        public static void main(String[] args) {

          int myNum = 5;
            String website = "rahulshettyacademy";
            char letter = 'a';
            double dec = 9.99;
            boolean myCard = true;

            System.out.println(myNum+" is the number stored in myNum variable");
            System.out.println(website);

            int[] arr = {1,2,3,4,5};
            for (int i=0; i < arr.length;i++)
            {
                System.out.println(arr[i]);
            }

            String[] name = {"abi","anu","bala"};

            for (int i=0; i < name.length;i++)
            {
                System.out.println(name[i]);
            }
            for(String s: name)
            {
                System.out.println(s);
            }
        }

}
