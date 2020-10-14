import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;  
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;  
public class My_Fast_IO 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    public static void main(String[] args) 
    {
        PrintWriter o = new PrintWriter(new OutputStreamWriter(System.out));
        FastReader s=new FastReader(); 
        // CODE BEGIN
        int n = s.nextInt();
        o.println(n);

        //CODE END
        // o.flush()
        o.close();
    } 
}