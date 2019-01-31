public class recursion{
  public static double sqrt(double x){
    //x / 2 is the guess.
    return SquareRoot(x, x / 2);
  }
  //private helper for sqrt.
  private static double percentError(double n, double guess){
    //percent error formula.
    return ((guess * guess - n) / n) * 100;
  }
  private static double SquareRoot(double n, double guess){
    if (Math.abs(percentError(n, guess)) <= 0.001){
      return guess;
    }
    else{
      //recursive part that makes the number closer and closer.
      guess = ( n / guess + guess) / 2;
      return SquareRoot(n, guess);
    }
  }
}
