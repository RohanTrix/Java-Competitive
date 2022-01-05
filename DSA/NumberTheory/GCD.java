package DSA.NumberTheory;

import java.util.Arrays;

public class GCD {

    public static void main(String[] args) {
        int a = 16;
        int b = 24;
        System.out.println(Arrays.toString(phi_1_to_n(21)));
    }
    // ----------------------------------GCD in log(min(a,b)) ---------------------------------
    static long gcd(long a, long b)
    {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
    // ------------------------------------------------------------------------------------

    // ----------------------------------Extended GCD in log(min(a,b)) ---------------------------------

    // returns {gcd, x, y} such gcd(a,b) = a*x + b*y
    public static long[] gcdExtended(long a, long b)
    {
        if(b == 0)
            return a > 0 ? new long[]{a,1,0} : new long[]{-a,-1,0};
        long r[] = gcdExtended(b, a%b);

        return new long[] {r[0], r[2], r[1] - a/b *r[2]};
    }
    // ------------------------------------------------------------------------------------

    // ----------------------------------Totient (phi) in O(sqrt(n)) ---------------------------------
    static int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }
    // ------------------------------------------------------------------------------------

    // --------------------Totient (phi) MULTIPLE QUERIES in O(n loglog n) ----------------
    static int[] phi_1_to_n(int n)
    {
        int phi = new int[n+1];
        phi[0] = 0;
        phi[1] = 1;
        for(int i = 2; i<n; i++) phi[i] = i;

        for (int i = 2; i <= n; i++)
        {
            if (phi[i] == i) {
                phi[i]--;
                for (int j = i; j <= n; j += i)
                    phi[j] -= phi[j] / i;
            }
        }
        return phi;
    }
    // ------------------------------------------------------------------------------------

}
