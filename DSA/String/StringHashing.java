// For logic, REFER CodeNCode YT channel

// Instead of coding Rabin Karp, we can use computeSubStrHash() while doing a
// fixed sliding window. Only tradeoff being RabinKarp gets the job done

public class StringHashing {
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
