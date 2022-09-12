// For logic, REFER CodeNCode YT channel

// Instead of coding Rabin Karp, we can use computeSubStrHash() while doing a
// fixed sliding window. Only tradeoff being RabinKarp gets the job done in constant space

class StringHasher { // WORKING IMPLEMENTATION

    static final int multiplier = 43;
    static final Random rnd = new Random();
    static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
    static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
    static final int invMultiplier1 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod1))
            .intValue();
    static final int invMultiplier2 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod2))
            .intValue();

    long[] hash1, hash2;
    long[] inv1, inv2;
    int n;

    public StringHasher(String s) {
        n = s.length();
        hash1 = new long[n + 1];
        hash2 = new long[n + 1];
        inv1 = new long[n + 1];
        inv2 = new long[n + 1];
        inv1[0] = 1;
        inv2[0] = 1;

        long p1 = 1;
        long p2 = 1;
        for (int i = 0; i < n; i++) {
            hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
            p1 = p1 * multiplier % mod1;
            inv1[i + 1] = inv1[i] * invMultiplier1 % mod1;
            hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
            p2 = p2 * multiplier % mod2;
            inv2[i + 1] = inv2[i] * invMultiplier2 % mod2;
        }
    }

    public long getHash(int i, int len) {
        return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32)
                + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;
    }
}


public class StringHashing { // Easy Implementation but has lot of collisions
    static long mod_inv[];
    static long pref[];
    static long m = (long)1e9+9;
    // --------------------Build prefix hash array and modulo inverse in O(n*log n)-----------------------
    public static void hashPrefixArray(String s)
    {
        int p = 31;
        long hash_val = 0;
        long p_pow = 1;
        pref = new long[s.length()];
        mod_inv = new long[s.length()];
        int i = 0;
        for(char ch : s.toCharArray())
        {
            hash_val = (hash_val + (ch - 'a' +1) *p_pow) % m;
            pref[i] = hash_val;
            mod_inv[i] = binpow(p_pow, m - 2);
            p_pow = (p_pow * p) % m;
            i++;
        }
        
    }
    // ---------------------------------------------------------------
    // --------------------Find a^b in log(b) -----------------------
    public static long binpow(long a, long b)
    {
        a%=m;
        long res = 1;
        while(b>0)
        {
            if((b&1)==1)
            {
                res = res * a % m;
            }
            a = a * a % m;
            b>>=1;
        }
        return res;
    }
    // -----------------------------------------------------------------------
    // --------------------Compute Hash of any subtring in O(1)----------------
    public static long computeSubStrHash(int l, int r)
    {
        long res = pref[r] - ((l>0)?pref[l-1]:0);

        res = (res*mod_inv[l])%m;
        return res;
    }
    // ------------------------------------------------------------------

    // --------------------Hash Value of String O(n) --------------------
    public static long computeHash(String s)
    {
        int p = 31;
        long hash_val = 0;
        long p_pow = 1;
        for(char ch : s.toCharArray())
        {
            hash_val = (hash_val + (ch - 'a' +1) *p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash_val;
    }
    // --------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println(computeHash("sir")); // Hash of String

        hashPrefixArray("rohansiro"); // Precomputing prefix hash array for O(1) substring hash
        System.out.println(computeSubStrHash(5,7));
    }
}
