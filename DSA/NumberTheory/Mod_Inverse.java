package DSA.NumberTheory;
public class Mod_Inverse {
    public static void main(String[] args) {
        int mod  = 1000000007;
        int N = (int)2e5+5; // try n=20 to see results instead of this bigger input
        System.out.println(modInv_1_to_n(N,mod));
    }


    // ----------------------------------MOD Inverse from 1 to n in O(n) ---------------------------------
    static int[] modInv_1_to_n(int n, int m)
    {
        int inv[] = new int[n+1];
        inv[1] = 1;
        for(int i = 2; i<=n; i++)
        {
            inv[i] = m - ((m/i)*inv[m%i]) % m;
        }
        return inv;
    }
    // ---------------------------------------------------------------------------------------------------

    // ----------------------------------MOD Inverse in log(min(a,b)) ---------------------------------
    static long modInv_use_GCD(long a, long m)
    {
        return (gcdExtended(a, m)[1] % m + m) % m;
    }
    public static long[] gcdExtended(long a, long b)
    {
        if(b == 0)
            return a > 0 ? new long[]{a,1,0} : new long[]{-a,-1,0};
        long r[] = gcdExtended(b, a%b);

        return new long[] {r[0], r[2], r[1] - a/b *r[2]};
    }
    // ------------------------------------------------------------------------------------


}
