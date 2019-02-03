import java.util.ArrayList;
public class Recursion{
  private ArrayList<Integer> arraySums;
  public ArrayList<Integer> getarraySums(){
    return arraySums;
  }
  /*Recursively find the sqrt using Newton's approximation
  *tolerance is the allowed percent error the squared answer is away from n.
  *precondition: n is non-negative*/
  public static double sqrt(double x, double tolerance){
    //x / 2 is the guess.
    return sqrtHelper(x, x / 2, tolerance);
  }
  //private helper for sqrt.
  public static double percentError(double n, double guess){
    //percent error formula.
    return ((guess * guess - n) / n) * 100;
  }
  public static double sqrtHelper(double n, double guess, double tolerance){
    if (percentError(n, guess) <= tolerance && percentError(n, guess) >= -1 * tolerance){
      return guess;
    }
    else{
      //recursive part that makes the number closer and closer.
      guess = ( n / guess + guess) / 2;
      return sqrtHelper(n, guess, tolerance);
    }
  }
  /*Recursively find the n'th fibbonaci number in linear time
  *fib(0) = 1; fib(1) = 1; fib(5) = 5
  *precondition: n is non-negative*/
  public static int fib(int n){
    //base cases.
    if (n == 0){
      return 0;
    }if (n == 1){
      return 1;
    }
    //recursive.
    else{
      return fib(n - 1) + fib(n - 2);
    }
  }
  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    arrList.add(0);
    return allSumsHelper(n, arrList);
  }

  public static ArrayList<Integer> allSumsHelper(int total, ArrayList<Integer> arrList){
    //base case.
    if (total == 0) return arrList;
    else{
      allSumsHelper(total - 1, arrList);
      int lenlist = arrList.size();
      for (int x = 0; x < lenlist; x++){
        if (!(arrList.contains(arrList.get(x) + total))){
          arrList.add(arrList.get(x) + total);
        }
      }
    }
    return arrList;
  }
  public static void main(String[] args) {
     System.out.println(makeAllSums(0));
     System.out.println(makeAllSums(6));
     System.out.println(makeAllSums(3));

   }

}
