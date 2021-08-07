
import java.util.*;

// REFER: Zenith CP Course-  String Algortihms

public class KMP {
    public static int[] getLPS(String s)
    {
        int n = s.length();
        int lps[] = new int[n+1];
        int i = 0, j = -1;
        lps[0] = -1;
        while(i<n)
        {
            while(j!=-1 && s.charAt(j)!=s.charAt(i)) j = lps[j];
            i++;j++;
            lps[i] = j;
        }
        return lps;
    }
    public static int matchSubstring(String s, String pat)
    {
        if(pat.length()==0) return 0;

        int pat_len = pat.length();
        String str = pat + "#" + s;

        int lps[] = getLPS(str);
        int cnt = 0;

        for(int i =pat_len+1; i<str.length(); i++)
        {
            if(lps[i]==pat_len)cnt++;
        }
        return cnt;
    }
    public static void main(String args[])
    {
        String s = "ababbaabab";
        String pat = "ba";
        int LPS[] = getLPS(s);
        System.out.println(Arrays.toString(LPS));
        System.out.println(matchSubstring(s, pat));
    }
}
