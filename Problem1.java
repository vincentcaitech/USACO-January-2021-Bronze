import java.util.*;
import java.io.*;

public class Problem1 {
  public static void main(String[] args)  throws IOException{
    Scanner sc = new Scanner(System.in);

    //Step 1: Get the alphabet and the desired string from input
    String alphabet = sc.nextLine();
    String str = sc.nextLine();
    int startingPt = 0; //where to start in the alphabet, starting at beginning, string index 0
    int count = 1; //total times the alphabet is sung. Start at 1, must go through it at least once.

    //Step 2: Iterate through each letter of the input string, from left to right.
    for(int i = 0;i<str.length();i++){
      String s = str.substring(i,i+1);
      boolean isFound = false;

      //Step 2.1: Iterate through the alphabet to see where this letter is, and update the starting point.
      for(int a =startingPt;a<alphabet.length();a++){
        if(alphabet.substring(a,a+1).equals(s)){ //if it is found at this place in the alphabet
          isFound = true;
          startingPt = a+1; //next iteration, start at the next letter in the alphabet
          break;
        }
      }

      //Step 2.2: If it is not found in the alphabet, start from the top and iterate through again, adding to the "count" of how many times you iterate through the whole alphabet
      if(!isFound){
        count++;
        for(int a =0;a<alphabet.length();a++){
        if(alphabet.substring(a,a+1).equals(s)){
          isFound = true;
          startingPt = a+1;
          break;
        }
        }
      }
    }

    //Step 3: print out the answer
    System.out.println(count);
    
    sc.close();
  }
}