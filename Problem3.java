import java.util.*;
import java.io.*;

public class Problem3 {
  public static void main(String[] args)  throws IOException{
    Scanner sc = new Scanner(System.in);

    //Step 1: Get data into arrays.
    int N = Integer.parseInt(sc.nextLine());
    String[] aList = sc.nextLine().split(" ");
    String[] bList = sc.nextLine().split(" ");

    //Convert to int arrays.
    int[] a = new int[aList.length];
    int[] b = new int[bList.length];
    int i = 0;
    for(String s: aList){
      a[i] = Integer.parseInt(s);
      i++;
    }
    i = 0;
    for(String s: bList){
      b[i] = Integer.parseInt(s);
      i++;
    }

    //Step 2: Sort both arrays.
    Arrays.sort(a);
    Arrays.sort(b);

    //Step 3: loop through each STALL, in order, and multiply the product by the amount of remaining cows that can fill that stall on each iteration.
    long product = 1;
    i = 0; //now used to count iterations
    for(int max:b){
      int count = 0;
      //Step 3.1: check how many cows can fit under this stall max
      for(int cow:a){
        if(cow<=max) count++;
      }
      //(number of remaing cows that can fit) = (total num of cows that can fit) - (already used cows)
      int n = count -i;
      product *= n; //multiply product by this value;
      i++; //add another cow that is already used;
    }

    //print out product
    System.out.println(product);
    sc.close();
  }
}