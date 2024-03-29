package DSA.NumberTheory;

import java.util.*;

public class Factorization {
  
  public static void main(String args[]) {
    System.out.println(SPF_countDiv(100));
  }

  // ----------------------------------SEIVE OF ERASTOTHENES---------------------------------
  public static boolean[] generatePrimes(int n) {
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, 2, n + 1, true);

    for (int i = 2; i * i <= n; i++)
      if (prime[i])
        for (int j = i * i; j <= n; j += i)
          prime[j] = false;

    return prime;
  }
  // ------------------------------------------------------------------------------------

  // ----------------------------------SMALLEST PRIME FACTOR---------------------------------
  public static int[] generateSPF(int n) {
    int[] spf = new int[n + 1];
    Arrays.fill(spf, 2, n + 1, -1);

    for (int i = 2; i<= n; i++)
      if(spf[i] == -1)
      {
        spf[i] = i;
        for (int j = i * i; j <= n; j += i)
          if(spf[j] == -1)
            spf[j] = i;
      }
    return spf;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- PRIME CHECK---------------------------------------
  public static boolean isPrime(long n) {
    if (n <= 1)
      return false;
    for (long i = 2; i * i <= n; i++)
      if (n % i == 0)
        return false;
    return true;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- ALL DIVISORS---------------------------------------
  public static ArrayList<Long> getDivisors(long n) {
    ArrayList<Long> ans = new ArrayList<>();
    for (long i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        ans.add(i);
        if (i * i != n)
          ans.add(n / i);
      }
    }
    return ans;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- PRIME FACTORIZE---------------------------------------
  public static ArrayList<pair> factorize(long n) {
    ArrayList<pair> ans = new ArrayList<>();
    for (long i = 2; i*i <= n; i++) {
      if (n % i == 0) {
        int cnt = 0;
        while(n%i==0)
        {
          cnt++;
          n/=i;
        }
        ans.add(new pair(i,cnt));
      }
    }
    if(n>1) ans.add(new pair(n,1));
    return ans;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- PRIME FACTORIZE MULTIPLE QUERY---------------------------------------
  public static ArrayList<Integer> SPF_factorize(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    int spf[] = generateSPF(n);
    while(n>1)
    {
      ans.add(spf[n]);
      n/=spf[n];
    }
    return ans;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- COUNT DIVISORS---------------------------------------
  public static int countDiv(int n) {
    int ans = 1;
    for(int i = 2; i*i<=n; i++)
    {
      int cnt = 0;
      while(n%i==0)
      {
        n/=i;
        cnt++;
      }
      ans*=(cnt+1);
    }
    if(n>1) ans*=2;
    return ans;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- COUNT DIVISORS MULTIPLE QUERIES---------------------------------------
  public static int SPF_countDiv(int n) {
    
    int spf[] = generateSPF(n);
    int ans = 1, prev = spf[n];
    int cnt = 1;
    n = n/prev;
    while(n>1)
    {
      if( spf[n] == prev)
      {
        cnt++;
      }
      else
      {
        prev = spf[n];
        ans*=(cnt+1);
        cnt = 1;
      }
      n = n/prev;
    }
    if(n>1) ans*=(cnt+1);
    return ans;
  }
  // ------------------------------------------------------------------------------------

  // ---------------------------------- SUM OF DIVISORS---------------------------------------
  public static int sumDiv(int n) {
    int ans = 1;
    for(int i = 2; i*i<=n; i++)
    {
      int sum = 1;
      int term = 1;
      while(n%i==0)
      {
        n/=i;
        term*=i;
        sum+=term;
      }
      res*=sum;
    }
    if(n>1) ans*=(n+1);
    return ans;
  }
  // ------------------------------------------------------------------------------------
  static class pair
  {
    long x,y;
    public pair(long x, long y)
    {
      this.x = x;
      this.y = y;
    }
    public String toString()
    {
      return "["+x+" "+y+"]";
    }
  }
}