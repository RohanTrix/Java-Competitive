package DSA.NumberTheory;
public class Combinations {
    long mod  = 1000000007L;
    int N = (int)2e5+5;
    long[] fact = new long[N+1];
    long[] ifact = new long[N+1];
    public long binpow(long a, long b)
    {
        a%=mod;
        long res = 1;
        while(b>0)
        {
            if((b&1)==1)
            {
                res = res * a % mod;
            }
            a = a * a % mod;
            b>>=1;
        }
        return res;
    }
    public void init()
    {
        fact[0] =1 ;
        ifact[0] = 1 ;
        for(int i=1;i<=N;++i)
        {
            fact[i] = (fact[i-1] * i )%mod ; 
            ifact[i] = binpow(fact[i],mod-2) ; 
	    }
    }
    long nCr(long n,long r)
    {
        long ans =1 ;
        
        if(r>n || r< 0) return 0L ;
    
        ans = (ans*fact[(int)n])%mod ;
        ans= (ans*ifact[(int)(n-r)])%mod ;
        ans= (ans*ifact[(int)r])%mod ;
        return ans ; 
        
    }
    public static void main(String args[])
    {
        Combinations ob = new Combinations();
        ob.init();
        System.out.println(ob.nCr(10,4));
    }
}
