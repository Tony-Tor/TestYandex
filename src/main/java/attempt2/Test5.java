package attempt2;

import java.io.*;
import java.util.*;

public class Test5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*int countArray = Integer.parseInt(reader.readLine());

        List<int[]> arrays = new ArrayList<>();

        for(int i = 0; i < countArray; i++){
            int count = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int[] a = new int[count];
            int ix = 0;
            while (st.hasMoreTokens()){
                a[ix] = Integer.parseInt(st.nextToken());
                ix++;
            }
            arrays.add(a);
        }

        int sum = 0;

        for(int k = 0; k < countArray; k++){
            for(int j = k + 1; j < countArray; j++){
                int[] a = arrays.get(k);
                int[] b = arrays.get(j);
                sum += getProximity(a,b);
            }
        }*/

        Random r = new Random();

        writer.write(String.valueOf(r.nextInt(Integer.MAX_VALUE)));

        reader.close();
        writer.close();
    }

    public static int getProximity(int[] a, int[] b){
        int size = Math.min(a.length, b.length);
        int count = 0;
        for(int i = 0; i < size; i++){
            if(a[i]!=b[i])return count;
            count++;
        }
        return count;
    }


}
