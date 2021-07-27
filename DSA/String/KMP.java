import java.util.*;
public class KMP {
    public static int[] getLPS(String s)
    {
        int n = s.length();
        int lps[] = new int[n+1];
        int i = 0, j = -1;
        lps[0] = -1;
        while(i<n)
        {
            while(j!=-1 && s.charAt(j)!=s.charAt(i))
                j = lps[j];
            i++;
            j++;
            lps[i] = j;
        }
        return lps;
    }
    public static void main(String args[])
    {
        String s = "ababbaabab";
        int LPS[] = getLPS(s);
        System.out.println(Arrays.toString(LPS));
        
    }
}
