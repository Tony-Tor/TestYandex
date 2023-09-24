package attempt3;

import java.io.*;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //FileWriter writer = new FileWriter("output.txt");

        //StringTokenizer lang = new StringTokenizer(reader.readLine(), " ");

        /*while (lang.hasMoreTokens()){
            int token = Integer.parseInt(lang.nextToken());
        }*/
        double n = Integer.parseInt(reader.readLine());
        double m = Integer.parseInt(reader.readLine());
        double c2 = Integer.parseInt(reader.readLine());
        double c5 = Integer.parseInt(reader.readLine());

        double freePort = m - n;

        if(freePort<=0) {
            System.out.println();
            writer.write(""+0);
            reader.close();
            writer.flush();
            return;
        }

        //writer.write(result);

        reader.close();
        writer.close();
    }

    //public static double result()
}
