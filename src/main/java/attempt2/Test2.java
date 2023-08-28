package attempt2;

import java.io.*;
import java.util.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String,Integer> cardSum = new HashMap<>();

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        st.nextToken();
        st.nextToken();
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");

        while (st.hasMoreTokens()){
            String card = st.nextToken();
            int count = cardSum.getOrDefault(card,0)+1;
            cardSum.put(card, count);
        }

        st = new StringTokenizer(reader.readLine(), " ");

        while (st.hasMoreTokens()){
            String card = st.nextToken();
            int count = cardSum.getOrDefault(card,0)-1;
            cardSum.put(card, count);
        }

        String result = " ";

        for (int k = 0; k < Q; k++){
            st = new StringTokenizer(reader.readLine(), " ");

            String type = st.nextToken();
            String player = st.nextToken();
            String card = st.nextToken();

            int count = cardSum.getOrDefault(card,0);

            if(player.equals("A")){
                if(type.equals("1")){
                    cardSum.put(card, count+1);
                } else {
                    cardSum.put(card, count-1);
                }
            } else {
                if(type.equals("1")){
                    cardSum.put(card, count-1);
                } else {
                    cardSum.put(card, count+1);
                }
            }

            int sum = 0;

            for (int i:cardSum.values()){
                sum += Math.abs(i);
            }

            result += " " + sum;
        }

        writer.write(result.trim());

        reader.close();
        writer.close();
    }
}
