package NumberTheory;
import java.util.*;

public class Factorization {
  static boolean[] prime;
  public static void main(String args[])
  {
      System.out.println(generatePrimes(10));
  }
  //----------------------------------SEIVE OF ERASTOTHENES---------------------------------
  public static int[] generatePrimes(int n) {
    prime = new boolean[n + 1];
    Arrays.fill(prime, 2, n + 1, true);

    for (int i = 2; i * i <= n; i++)
      if (prime[i])
        for (int j = i * i; j <= n; j += i)
          prime[j] = false;
    
    int[] primes = new int[n + 1];
    int cnt = 0;
    for (int i = 0; i < prime.length; i++)
      if (prime[i])
        primes[cnt++] = i;

    return Arrays.copyOf(primes, cnt);
  }
  //------------------------------------------------------------------------------------

  //---------------------------------- PRIME CHECK---------------------------------------
  public static boolean isPrime(long n) {
    if (n <= 1)
      return false;
    for (long i = 2; i * i <= n; i++)
      if (n % i == 0)
        return false;
    return true;
  }
  //------------------------------------------------------------------------------------
  


}