public class recursion{
  public static double sqrt(double x){
    return SquareRoot(x, x - 1);
  }
  public static double SquareRoot(double n, double guess){
    if (Math.abs(guess * guess - n) <= 0.00001){
      return guess;
    }
    else{
      guess = ( n / guess + guess) / 2;
      return SquareRoot(n, guess);
    }
  }
}
