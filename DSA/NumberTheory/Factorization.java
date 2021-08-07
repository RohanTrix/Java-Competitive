package NumberTheory;


import java.util.*;

public class Factorization {

  public static void main(String args[])
  {
      System.out.println(numberOfPrimeDivisors(10));
  }
  public static int[] generatePrimes(int n) {
    boolean[] prime = new boolean[n + 1];
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
  public static boolean isPrime(long n) {
    if (n <= 1)
      return false;
    for (long i = 2; i * i <= n; i++)
      if (n % i == 0)
        return false;
    return true;
  }
  public static int[] numberOfPrimeDivisors(int n) {
    int[] divisors = new int[n + 1];
    Arrays.fill(divisors, 2, n + 1, 1);
    for (int i = 2; i * i <= n; ++i)
      if (divisors[i] == 1)
        for (int j = i; j * i <= n; j++)
          divisors[j * i] = divisors[j] + 1;
    return divisors;
  }


}