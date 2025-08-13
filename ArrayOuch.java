import java.io.*;
public class ArrayOuch {
     public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Enter a Size of an Array: ");
      int index = Integer.parseInt(br.readLine());
      int [] number = new int[index];
      String even = "Even: ";
      String odd = "Odd: ";
      boolean even1 = true;
      boolean odd1 = true;

      for (int i = 0; i < number.length; i++) {
        //Check if the Number if Even or Odd
          System.out.println("Enter a number for index " + (i + 1)+ ": ");
          number[i] = Integer.parseInt(br.readLine());
          if (number[i] % 2 == 0) {
            if(!even1){
              even +=", ";
            }
            even += number[i];
            even1 = false;
          } else {
            if(!odd1){
              odd +=", ";
            }
            odd += number[i];
            odd1 = false;
          }
      }
      System.out.println(even);
      System.out.println(odd);
     }
}


