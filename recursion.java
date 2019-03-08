import java.util.ArrayList;
public class recursion{
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
    if (n == 0){
      return 0.0;
    }
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
    //recursive, adds previous 2 numbers.
    else{
      return fib(n - 1) + fib(n - 2);
    }
  }

  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    return allSumsHelper(n, 0,  arrList);
  }

  public static ArrayList<Integer> allSumsHelper(int total, int sum, ArrayList<Integer> arrList){
    //base case when total reaches lowest so the method can add the sum.
    if (total == 0){
      arrList.add(sum);
      return arrList;
   }
    else{
      //recursion that make sum the same, or adds total to sum to get all possible combinations.
      allSumsHelper(total - 1, total + sum, arrList);
      allSumsHelper(total - 1, sum, arrList);
      //changes the arrays, then returns it.
      return arrList;
    }
  }
  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}
  //test out makeallsums.
  public static void main(String[] args) {
for (int i = 0; i < 5; i++){
  testSqrt(i);
}
   }

}
