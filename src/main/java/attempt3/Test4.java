package attempt3;

import java.io.*;
import java.util.*;

public class Test4 {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Pair> integerPairMap = new HashMap<>();

        int result = 0;
        int destroy = 0;

        TreeMap<Integer,Integer> maxLen = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            StringTokenizer lang = new StringTokenizer(reader.readLine(), " ");
            int day = Integer.parseInt(lang.nextToken());
            int road = Integer.parseInt(lang.nextToken());

            Pair pair = integerPairMap.get(road);
            if(pair == null){
                Pair np = new Pair();
                np.list.add(day);
                integerPairMap.put(road, np);
                destroy++;
            } else {
                result = result - (pair.list.get(pair.list.size()-1) - pair.list.get(0));
                maxLen.put(day-pair.list.get(pair.list.size()-1),0);
                pair.list.add(day);
                result = result + (pair.list.get(pair.list.size()-1) - pair.list.get(0));
            }
        }

        if(destroy > m){
            writer.write("" + (-1));
            reader.close();
            writer.close();
            return;
        }

        if(destroy < m){
            int repairs = m - destroy;
            for (Integer i:maxLen.navigableKeySet()){
                result -= i;
                repairs -= 1;
                if (repairs == 0)break;
            }

        }

        writer.write("" + result);

        reader.close();
        writer.close();
    }

    public static class Pair{
        List<Integer> list = new ArrayList();
    }
    //public static double result()
}
