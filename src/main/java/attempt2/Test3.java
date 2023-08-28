package attempt2;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> strings = new ArrayList<>();
        Map<String, List<Constraint>> columnNames = new HashMap<>();
        List<String> columns = new ArrayList<>();

        String[] strS = reader.readLine().split(" ");

        int N = Integer.parseInt(strS[0]);
        int M = Integer.parseInt(strS[1]);
        int Q = Integer.parseInt(strS[2]);

        String[] Ss = reader.readLine().split(" ");

        for(String s:Ss){
            columns.add(s);
            columnNames.put(s, new ArrayList<>());
        }


        for(int n = 0; n < N; n++){
            String[] S = reader.readLine().split(" ");
            ArrayList<Integer> string = new ArrayList<>();
            for(String s:S){
                string.add(Integer.parseInt(s));
            }
            strings.add(string);
        }

        for(int q = 0; q < Q; q++){
            String[] S = reader.readLine().split(" ");
            String columnName = S[0];
            String ops = S[1];
            int num = Integer.parseInt(S[2]);
            List<Constraint> list = columnNames.get(columnName);
            list.add(new Constraint(ops, num));
        }

        long res = 0;

        for(List<Integer> integers:strings){
            long sum = 0;
            out:
            for(int i = 0; i < integers.size(); i++){
                String columnName = columns.get(i);
                List<Constraint> constraints = columnNames.get(columnName);
                int test = integers.get(i);
                for (Constraint constraint:constraints){
                    if(!constraint.test(test)) {
                        sum = 0;
                        break out;
                    }
                }
                sum += test;
            }
            res += sum;
        }

        writer.write(String.valueOf(res));

        reader.close();
        writer.close();
    }

    public static class Constraint{
        boolean type;
        int val;

        public Constraint(String type, int val) {
            this.type = type.equals("<");
            this.val = val;
        }

        public boolean test(int test){
            if(type){
                return test < val;
            } else {
                return test > val;
            }
        }
    }
}
