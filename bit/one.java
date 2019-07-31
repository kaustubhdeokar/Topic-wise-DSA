
import java.io.*;
import java.util.*;

class problem4 {
    static class fastreader
    {
        BufferedReader br;
        StringTokenizer st;

        public fastreader()
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
                catch (IOException e)
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
    public static void main(String[] args) {
        fastreader sc = new fastreader();
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            double X[] = new double[n];
            double Y[] = new double[n];
            double array_1[] = new double[n];
            double array_2[] = new double[n];
            for (int i = 0; i < n; i++) {
                X[i] = sc.nextDouble();
                Y[i] = sc.nextDouble();
                array_1[i] = X[i]+Y[i];
                array_2[i] = X[i]-Y[i];
            }
            Arrays.sort(array_1);
            Arrays.sort(array_2);
            double min = Math.abs((array_1[0]-array_1[1])/2);
            min = Math.min(Math.abs((array_2[0]-array_2[1])/2),min);
            for (int i = 1; i < n-1; i++) {
                min = Math.min(Math.abs((array_1[i]-array_1[i+1])/2),min);
                min = Math.min(Math.abs((array_2[i]-array_2[i+1])/2),min);
                if(min==0.0)
                {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}