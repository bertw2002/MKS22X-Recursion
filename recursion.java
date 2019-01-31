public class recursion{
  /*Recursively find the sqrt using Newton's approximation
  *tolerance is the allowed percent error the squared answer is away from n.
  *precondition: n is non-negative*/
  public static double sqrt(double x, double tolerance){
    //x / 2 is the guess.
    return SquareRoot(x, x / 2, tolerance);
  }
  //private helper for sqrt.
  private static double percentError(double n, double guess){
    //percent error formula.
    return ((guess * guess - n) / n) * 100;
  }
  private static double SquareRoot(double n, double guess, double tolerance){
    if (Math.abs(percentError(n, guess)) <= tolerance){
      return guess;
    }
    else{
      //recursive part that makes the number closer and closer.
      guess = ( n / guess + guess) / 2;
      return SquareRoot(n, guess, tolerance);
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

}
