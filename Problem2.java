import java.util.*;
import java.io.*;

public class Problem2{
  public static void main(String[] args)  throws IOException{
    Scanner sc = new Scanner(System.in);

    //Step 1: Get N and the list of photos from input
    int N = Integer.parseInt(sc.nextLine());
    String[] photos = sc.nextLine().split(" ");

    //Step 2: Count all evens and odds, EACH REPRESENTING A GROUP. 
    //NOTE: the most possible groups you have is when each photo is it's own separate group (groups of size 1)
    int odds = 0;
    int evens = 0;
    for(String s: photos){
      if(Integer.parseInt(s)%2==0){
        evens++;
      }else{
        odds++;
      }
    }

    /***
    NOTE: the groups MUST satisfy one of the following conditions to make the arrangement possible:
    1). the number of evens EQUALS the number of odds
    2). the number of evens is EXACTLY ONE MORE than the number of odds (because you start on an even)
    ***/
    
    
    boolean isBreak = false;
    while(!isBreak){

      //Step 3: Check if this group arrangement satisfies any of the above conditions
      if(odds==evens||odds+1==evens){
        isBreak = true;
        break;
      }else if(evens+1==odds){ //Step 4: if there is one more odd than even, subtract two from the odds and it will satisfy the condition.
        //this is because you group two odds together (an even sum) and put them together with any other group, and it's parity will not change. 
        //This is the best way to reduce the amount of odds and maintain the maximum amount of total groups.
        odds -= 2;
        isBreak = true;
        break;
      }else{
        //Step 5: If both the above conditions are NOT satisfied, then two possible cases: too many odds or too many evens
        if(odds>evens){
          //If there are too many odds, than take two odd groups, add them to make and even sum, and put that in it's separate group
          odds -= 2;
          evens += 1;
          /*NOTE: this is the optimal solution because it decreases the total number of groups by a minimum of 1 each iteration. (subtract two odds, add one even, net change of -1). */
        }else if(evens>odds){
          //If there are too many evens, just minus an even. Do this by adding two even groups into it's own separate group (which will have an even sum);
          evens--;
          /*NOTE: this is also the optimal solution for the same reason: because it decreases the total number of groups by a minimum of 1 each iteration.  */
        }
      }

      //Step 6: Repeat steps  3-5 until one of the conditions is satisifed, hence a while loop

    }

    //Step 7: add the number of odd and even groups, to print out total number of groups.
    int res = odds + evens;
    System.out.println(res);
    sc.close();




  }
}