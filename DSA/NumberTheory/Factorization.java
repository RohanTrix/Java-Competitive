
import java.util.*;

public class Factorization {

  public static void main(String args[])
  {
      System.out.println("Factorize 10 : "+factorize(10));
      System.out.println("All Divisors : "+Arrays.toString(getAllDivisors(10)));
  }


  // MAP : prime_divisor -> power
  public static Map<Long, Integer> factorize(long n) {
    Map<Long, Integer> factors = new LinkedHashMap<>();
    for (long d = 2; n > 1; ) {
      int power = 0;
      while (n % d == 0) {
        ++power;
        n /= d;
      }
      if (power > 0) {
        factors.put(d, power);
      }
      ++d;
      if (d * d > n) {
        d = n;
      }
    }
    return factors;
  }

  public static int[] getAllDivisors(int n) {
    List<Integer> divisors = new ArrayList<>();
    for (int d = 1; d * d <= n; d++)
      if (n % d == 0) {
        divisors.add(d);
        if (d * d != n)
          divisors.add(n / d);
      }
    int[] res = new int[divisors.size()];
    for (int i = 0; i < res.length; i++)
      res[i] = divisors.get(i);
    Arrays.sort(res);
    return res;
  }
}