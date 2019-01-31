public class recursion{
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

}
