package attempt3;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //FileWriter writer = new FileWriter("output.txt");

        //StringTokenizer lang = new StringTokenizer(reader.readLine(), " ");

        /*while (lang.hasMoreTokens()){
            int token = Integer.parseInt(lang.nextToken());
        }*/

        StringTokenizer str = new StringTokenizer(reader.readLine(), " ");

        double n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        StringTokenizer wood = new StringTokenizer(reader.readLine(), " ");

        double sum = 0;

        List<Double> arr = new ArrayList<>();

        while (wood.hasMoreTokens()){
            double token = Integer.parseInt(wood.nextToken());
            sum += token;
            arr.add(token);
        }

        double middle = sum/n;

        arr = arr.stream().sorted(((o1, o2) -> {
            double r1 = Math.abs(middle - o1);
            double r2 = Math.abs(middle - o2);
            if(r1 == r2)
                return 0;
            else if(r1 < r2)
                return 1;
            else return -1;
        })).collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = k; i < arr.size(); i++){
            min = (int) Math.min(min,arr.get(i));
            max = (int) Math.max(max,arr.get(i));
        }

        int result = Math.abs(max-min);


        writer.write(""+result);

        reader.close();
        writer.close();
    }

    //public static double result()
}
